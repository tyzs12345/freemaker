package com.tian.demo.util;

import com.tian.demo.constant.GeneraterConstants;
import com.tian.demo.model.Field;
import com.tian.demo.model.Table;

import java.util.List;

public class SQLGeneraterUtil
{
  public static void main(String[] args)
  {
  }

  public static String genCreateSql(Table table, List<Field> fieldList)
  {
    String sqlStr = "";
    sqlStr = genCreateSqlForMySql(table, fieldList);
    return sqlStr;
  }

  private static String genCreateSqlForMySql(Table table, List<Field> fieldList)
  {
    StringBuilder sb = new StringBuilder();
    if ((table != null) && (fieldList != null) && (!fieldList.isEmpty()))
    {
      sb.append("DROP TABLE IF EXISTS ");
      sb.append(table.getTableName());
      sb.append(";\n");

      sb.append("CREATE TABLE ");
      sb.append(table.getTableName());
      sb.append("(\n");
      String primaryKey = "";

      for (Field field : fieldList)
      {
        if ("Y".equals(field.getIsKey())) {
          primaryKey = field.getFieldName();
        }
        sb.append("\t");
        sb.append(field.getFieldName());
        sb.append(" ");
        sb.append((String)GeneraterConstants.MySQLFieldType.get(field.getFieldType()));
        if ((field.getFieldLength() > 0) && ("String".equals(field.getFieldType()))) {
          sb.append("(");
          sb.append(field.getFieldLength() + field.getPointLength());
          sb.append(")");
        }
        if ((field.getFieldLength() > 0) && (field.getPointLength() > 0) && ("Double".equals(field.getFieldType())))
        {
          sb.append("(");
          sb.append(field.getFieldLength() + field.getPointLength());
          sb.append(",");
          sb.append(field.getPointLength());
          sb.append(")");
        }

        if ("N".equals(field.getIsNull())) {
          sb.append(" NOT NULL");
        }

        if ((field.getFieldDefault() != null) && (!"".equals(field.getFieldDefault()))) {
          sb.append(" DEFAULT '");
          sb.append(field.getFieldDefault());
          sb.append("'");
        }
        else if (("Y".equals(field.getIsNull())) && (!"Timestamp".equals(field.getFieldType())) && 
          (!"Date".equals(field.getFieldType()))) {
          sb.append(" DEFAULT NULL");
        }

        sb.append(" COMMENT '");
        sb.append(field.getFieldDescribe());
        sb.append("',\n");
      }
      sb.append("\tPRIMARY KEY (");
      sb.append(primaryKey);
      sb.append(")\n");
      sb.append(") COMMENT='");
      sb.append(table.getTableDescribe());
      sb.append("';\n");
    }

    return sb.toString();
  }




}