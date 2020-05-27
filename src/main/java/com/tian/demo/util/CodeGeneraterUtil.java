package com.tian.demo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tian.demo.model.ColumnData;
import com.tian.demo.model.Field;
import com.tian.demo.model.Parameter;
import com.tian.demo.model.Table;
import com.tian.demo.service.FieldService;
import com.tian.demo.service.ParameterService;
import com.tian.demo.service.TableService;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.VelocityContext;

@Slf4j
public class CodeGeneraterUtil
{

  private final String URL = "jdbc:mysql://localhost:3306/123";
  private final String USER = "root";
  private final String PASSWORD = "root123";
  private final String DRIVER = "com.mysql.jdbc.Driver";
  /**
   * 表列数据
   */
  protected List<ColumnData> columnDataList = new ArrayList<ColumnData>();


  public  Connection getConnection() throws Exception{
    Class.forName(DRIVER);
    Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
    return connection;
  }

  public  String codeGenerater(String modelPackage, String tableNameIn, String db, String startsWithStr)throws Exception
  {
    Connection connection = null;
    String sqlColumns = "select column_name ,data_type, column_comment,numeric_precision,"
            + "numeric_scale,character_maximum_length,is_nullable nullable,column_key columnKey, extra extra "
            +  "from information_schema.columns where table_name =  '" + tableNameIn + "' "
            + "and table_schema =  '" + db + "'";
    log.info(sqlColumns);
    connection = getConnection();
    PreparedStatement ps = connection.prepareStatement(sqlColumns);
    ResultSet resultSet = ps.executeQuery();
    Table table = new Table();
    table.setTableName(tableNameIn);
    table.setTableDescribe("测试使用");

    while(resultSet.next())
    {
      String name = resultSet.getString(1).toLowerCase();//column_name
      String type = resultSet.getString(2);//data_type
      String comment = resultSet.getString(3);//column_comment
      String precision = resultSet.getString(4);//numeric_precision
      String scale = resultSet.getString(5);//numeric_scale
      String charmaxLength = resultSet.getString(6) == null ? "" : resultSet .getString(6);//character_maximum_length
      String nullable = resultSet.getString(7).toLowerCase().indexOf("y") == -1 ? "N" : "Y";//is_nullable
      String columnKey = resultSet.getString(8); //column_key
      ColumnData cd = new ColumnData();
      cd.setColumnName(name);
      String propName = this.getColumnName2PropName(name);
      cd.setPropName(propName);
      cd.setMethodName(propName.substring(0, 1).toUpperCase() + propName.substring(1, propName.length()));
      //设置类型
      initType(type, precision, scale, cd);
      cd.setColumnType(resultSet.getString(2));
      cd.setColumnComment(comment);
      cd.setPrecision(precision);
      cd.setScale(scale);
      cd.setCharmaxLength(charmaxLength);
      cd.setNullable(nullable);
      cd.setColumnKey(columnKey);
      //对于Date和Time类型，在页面显示时添加Str后缀属性
      if (cd.getPropType().indexOf("Date") > -1 || cd.getPropType().indexOf("Timestamp") > -1) {
        cd.setPropNameStr(cd.getPropName() + "Str");
        cd.setPropNameStrType("String");
        cd.setMethodNameStr(cd.getMethodName() + "Str");
      }
      log.info("----------" + cd.getPropNameStr());
      columnDataList.add(cd);
    }

    String tableName = table.getTableName().toLowerCase();
    if (tableName.startsWith(startsWithStr.toLowerCase())) {
      tableName = tableName.substring(startsWithStr.length());
    }

    String[] split = tableName.split("_");
    String className = "";

    if (split.length > 1) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < split.length; i++)
      {
        String tempTableName = split[i].substring(0, 1).toUpperCase() + 
          split[i].substring(1, split[i].length());
        sb.append(tempTableName);
      }
      className = sb.toString();
    }
    else {
      className = split[0].substring(0, 1).toUpperCase() + 
        split[0].substring(1, split[0].length());
    }

    String lowerName = className.substring(0, 1).toLowerCase() + className.substring(1, className.length());
   // ParameterService parameterService = (ParameterService)SpringUtils.getBean("parameterService");
   // Parameter parameter = parameterService.queryByParamName("codeGeneraterFilePath");
    Parameter parameter = new Parameter();
    parameter.setParamName("codeGeneraterFilePath");
    parameter.setParamValue("D:\\mnt\\");
    String codeGeneraterFilePath = parameter.getParamValue();
    String baseFilePath = codeGeneraterFilePath + System.currentTimeMillis() + "(" + table.getTableName() + ")" + File.separator;
    codeGeneraterFilePath = baseFilePath + table.getTableName() + File.separator;
    String srcPath = codeGeneraterFilePath + "src" + File.separator;
    String bizz_package = "";
    log.info("CodeGenerateFactory-srcPath:" + srcPath);
    String[] s = modelPackage.split("\\.");
    for (String string : s) {
      bizz_package = bizz_package + string + File.separator;
    }
    s = modelPackage.split("\\.");
    String modelPackage_ = modelPackage;
    modelPackage = "";
    for (String string : s) {
      modelPackage = modelPackage + string + File.separator;
    }

    String pckPath = srcPath;
    log.info("CodeGenerateFactory-pckPath:" + pckPath);

    String modelPath = modelPackage + File.separator + "model" + File.separator + "business" + File.separator + className + ".java";
    String modelVOPath = modelPackage + File.separator + "model" + File.separator + "vo" + File.separator + className + "VO.java";
    String daoPath = modelPackage + File.separator + "dao" + File.separator + className + "Dao.java";
    String serviceImplPath = modelPackage + File.separator + "service" + File.separator+ "serviceImpl" + File.separator + className + "ServiceImpl.java";
    String servicePath = modelPackage + File.separator + "service" + File.separator+ className + "Service.java";
    String controllerPath = modelPackage + File.separator + "controller" + File.separator + className + "Controller.java";

    String qoPath = modelPackage + File.separator + "qo" + File.separator + className + "QO.java";
    String voPath = modelPackage + File.separator + "vo" + File.separator + className + "VO.java";

    VelocityContext context = new VelocityContext();
    context.put("className", className);
    context.put("author", "lanyu");
    context.put("createDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    context.put("copyRight", "lanyu");
    context.put("lowerName", lowerName);
    context.put("tableComment", table.getTableDescribe());
    context.put("tableName", table.getTableName().toLowerCase());
    context.put("bizzPackage", modelPackage);
    context.put("modelPackage", modelPackage_);

    String keyType = "";
    String primaryKey = "id";
    String primaryProp = "";
    Set<String> importSet = new HashSet();
    String method;

    if (!importSet.isEmpty()) {
      StringBuilder sb = new StringBuilder();
      for (String string : importSet) {
        sb.append(string);
        sb.append("\n");
      }
      context.put("importString", sb.toString());
    }

    context.put("columnDatas", columnDataList);

    context.put("primaryKey", primaryKey);
    context.put("primaryProp", primaryProp);
    if ((primaryProp != null) && (!primaryProp.equals(""))) {
      context.put("UprimaryProp", 
        primaryProp.substring(0, 1).toUpperCase() + primaryProp.substring(1, primaryProp.length()));
    }
    context.put("keyType", keyType);
    log.info("CodeGenerateFactory-keyType:" + keyType);
    log.info("CodeGenerateFactory-primaryKey:" + primaryKey);
    log.info("CodeGenerateFactory-primaryProp:" + primaryProp);

    String modelHBMPath = modelPackage + File.separator + "model" + File.separator + className + ".java";
    String daoMapperPath = modelPackage + File.separator + "dao" + File.separator + className + "Dao.xml";
   // String rpcServicePath = modelPackage + File.separator + "rpc" + File.separator + className + "RpcService.java";
   // String rpcServiceFallbackPath = modelPackage + File.separator + "rpc" + File.separator + "impl" + File.separator + className + "RpcServiceFallback.java";

    TemplateParser.WriterPage(context,   "ControllerTemplate.ftl", pckPath, controllerPath);
    TemplateParser.WriterPage(context,   "MapperTemplate.xml", pckPath, daoMapperPath);
    TemplateParser.WriterPage(context,   "DaoTemplate.ftl", pckPath, daoPath);
    TemplateParser.WriterPage(context,   "ModelTemplate.ftl", pckPath, modelHBMPath);
    TemplateParser.WriterPage(context,   "ServiceTemplate.ftl", pckPath, servicePath);
    TemplateParser.WriterPage(context,   "ServiceImplTemplate.ftl", pckPath, serviceImplPath);

    //////
    TemplateParser.WriterPage(context,   "voTemplate.ftl", pckPath, voPath);
    TemplateParser.WriterPage(context,   "qoTemplate.ftl", pckPath, qoPath);

    List list = new ArrayList();
    list.add(codeGeneraterFilePath);
    /*String zipPath = baseFilePath + "zip" + File.separator + table.getTableName() + ".zip";
    String comment = table.getTableDescribe();
    try {
      ZipUtils.compress(list, zipPath, "UTF-8", comment);
    }
    catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }*/
    return "lllllllll";
  }

  private static String getBeanFeilds(List<Field> fieldList)
  {
    StringBuffer str = new StringBuffer();

    StringBuffer getset = new StringBuffer();
    for (Field f : fieldList)
    {
      String name = f.getFieldName();
      String type = f.getFieldType();
      String comment = f.getFieldDescribe();

      str.append("\r\t").append("private ").append(type + " ").append(name).append(";//").append(comment);

      String method = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
      getset.append("\r\t").append("public ").append(type + " ").append("get" + method + "() {\r\t");
      getset.append("\t").append("return this.").append(name).append(";\r\t}");
      getset.append("\r\t").append("public void ").append("set" + method + "(" + type + " " + name + ") {\r\t");
      getset.append("\t").append("this." + name + "=").append(name).append(";\r\t}");
    }
    return str.append("\r\t").toString() + getset.toString();
  }

  private static String getColumnName2PropName(String columnName)
  {
    columnName = columnName.toLowerCase();

    String[] split = columnName.split("_");

    if (split.length > 1) {
      StringBuffer sb = new StringBuffer();
      for (int i = 1; i < split.length; i++)
      {
        String tempPropName = split[i].substring(0, 1).toUpperCase() + 
          split[i].substring(1, split[i].length());
        sb.append(tempPropName);
      }
      return split[0] + sb.toString();
    }
    return columnName;
  }

  /**
   * 根据数据库表结构定义，映射java类型
   * @param dataType
   * @param precision
   * @param scale
   * @return
   */
  public void initType(String dataType, String precision, String scale, ColumnData columnData) {
    if (columnData == null) {
      return;
    }
    dataType = dataType.toLowerCase();
    if (dataType.contains("char")) {
      columnData.setPropType("String");
      columnData.setJdbcType("VARCHAR");
    } else if (dataType.contains("int")) {
      columnData.setPropType("int");
      columnData.setJdbcType("INTEGER");
    } else if (dataType.contains("float")) {
      columnData.setPropType("double");
      columnData.setJdbcType("DOUBLE");
    } else if (dataType.contains("double")) {
      columnData.setPropType("double");
      columnData.setJdbcType("DOUBLE");
    } else if (dataType.contains("number")) {
      if ((scale != null)
              && (Integer.parseInt(scale) > 0)) {
        columnData.setPropType("double");
        columnData.setJdbcType("DOUBLE");
      } else if ((precision != null)
              && (Integer.parseInt(precision) > 6)) {
        columnData.setPropType("long");
        columnData.setJdbcType("INTEGER");
      } else {
        columnData.setPropType("int");
        columnData.setJdbcType("INTEGER");
      }
    } else if (dataType.contains("decimal")) {
      columnData.setPropType("double");
      columnData.setJdbcType("DOUBLE");
    } else if (dataType.equalsIgnoreCase("date")) { //注意Mysql中用datetime的情况
      columnData.setPropType("java.util.Date");
      columnData.setJdbcType("DATE");
    } else if (dataType.contains("time")) { //注意Mysql中用datetime的情况，不能使用因为一个表实际只能有一个Timestamp且不能为空
      columnData.setPropType("Instant");
      columnData.setJdbcType("TIMESTAMP");
    } else if (dataType.contains("clob")) {
      columnData.setPropType("String");
      columnData.setJdbcType("VARCHAR");
    } else if (dataType.contains("text")) {
      columnData.setPropType("String");
      columnData.setJdbcType("VARCHAR");
    } else {
      columnData.setPropType("java.lang.Object");
      columnData.setJdbcType("VARCHAR");
    }
  }

}