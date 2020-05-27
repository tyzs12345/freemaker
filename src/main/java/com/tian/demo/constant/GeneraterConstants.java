package com.tian.demo.constant;

import java.util.HashMap;
import java.util.Map;

public class GeneraterConstants
{
  public static final String BIZZ_PACKAGE = "com.tera";
  public static final String IS_Y = "Y";
  public static final String IS_N = "N";
  public static final String daoType_MyBatis = "MyBatis";
  public static final String daoType_Hibernate = "Hibernate";
  public static final String uiType_jQueryEasyUI = "JQueryEasyUI";
  public static final String uiType_eruleUI = "EruleUI";
  public static final String dbType_MySQL = "MySQL";
  public static final String dbType_PostgreSQL = "PostgreSQL";
  public static final String dbType_Oracle = "Oracle";
  public static final Map<String, String> MySQLFieldType = new HashMap();

  public static final Map<String, String> PostgreSQLFieldType = new HashMap();

  public static final Map<String, String> OracleFieldType = new HashMap();

  static {
    MySQLFieldType.put("String", "varchar");

    MySQLFieldType.put("BigDecimal", "decimal");
    MySQLFieldType.put("Integer", "integer");
    MySQLFieldType.put("Long", "bigint");
    MySQLFieldType.put("Double", "double");
    MySQLFieldType.put("Date", "date");
    MySQLFieldType.put("Timestamp", "timestamp");

  }
}