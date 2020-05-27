package com.tian.demo.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import freemarker.template.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class TemplateParser
{
  private static final Log log = LogFactory.getLog(TemplateParser.class);
  private static VelocityEngine ve;
  private static final String CONTENT_ENCODING = "UTF-8";
  private static final String TEMPLATEPATH = "template";
  private static boolean isReplace = true;

  private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);
 /* static{
    //这里比较重要，用来指定加载模板所在的路径
    CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(TemplateParser.class, "/template"));
    CONFIGURATION.setDefaultEncoding("UTF-8");
    CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
  }*/
  static {
    try {
      String path1 = new TemplateParser().getClass().getClassLoader().getResource(File.separator).getPath();
      String path = path1.substring(0, path1.length() - 3);
      String templateBasePath = path + "template";
      Properties properties = new Properties();
      properties.setProperty("resource.loader", "file");
      properties.setProperty("file.resource.loader.description", "Velocity File Resource Loader");
      properties.setProperty("file.resource.loader.path", templateBasePath);
      properties.setProperty("file.resource.loader.cache", "true");
      properties.setProperty("file.resource.loader.modificationCheckInterval", "30");
      properties.setProperty("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.Log4JLogChute");
      properties.setProperty("runtime.log.logsystem.log4j.logger", "org.apache.velocity");
      properties.setProperty("directive.set.null.allowed", "true");
      VelocityEngine velocityEngine = new VelocityEngine();
      velocityEngine.init(properties);
      ve = velocityEngine;
    } catch (Exception e) {
      log.error(e);
    }
  }

  public static void WriterPage(VelocityContext context, String templateName, String fileDirPath, String targetFile)
  {
    try {
      File file = new File(fileDirPath + targetFile);
      if (!file.exists())
        new File(file.getParent()).mkdirs();
      else if (isReplace) {
        log.info("替换文件:" + file.getAbsolutePath());
      }
      Template template = ve.getTemplate(templateName, "UTF-8");
      //freemarker.template.Template template = CONFIGURATION.getTemplate(templateName);
      FileOutputStream fos = new FileOutputStream(file);
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
      template.merge(context, writer);
      writer.flush();
      writer.close();
      fos.close();
      log.info("生成文件：" + file.getAbsolutePath());
    } catch (Exception e) {
      log.error(e);
    }
  }
}