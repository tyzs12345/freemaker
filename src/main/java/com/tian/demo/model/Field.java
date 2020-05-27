package com.tian.demo.model;

import com.tian.demo.util.DateUtils;

import java.io.Serializable;


/**
 * 
 * 代码生成_表字段信息实体类 <b>功能：</b>FieldDao<br>
 * <b>作者：</b>CodeGenerater<br>
 * <b>日期：</b>2017-01-22 10:24:58<br>
 * <b>版权所有：<b>天瑞兴隆<br>
 */
public class Field implements Serializable {

	// 属性部分
	private String uuid; // 主键
	private String fieldName; // 字段名称
	private String fieldDescribe; // 字段描述
	private int fieldLength; // 字段长度
	private int pointLength; // 小数点长度
	private String fieldType; // 字段类型
	private String fieldDefault; // 字段默认值
	private String isKey; // 是否主键
	private String isNull; // 允许空值
	private String isQuery; // 查询字段
	private String isShow; // 显示字段
	private String isShowList; // 列表显示
	private String showType; // 控件类型
	private int showLength; // 显示长度
	private String dataDictionaryType; // 数据字典类型
	private String tableUuid; // 表UUID
	private int orderNum; // 排序
	private java.sql.Timestamp createdTime; // 创建时间
	private String createdTimeStr; // 创建时间
	private java.sql.Timestamp lastModifiedTime; // 最后修改时间
	private String lastModifiedTimeStr; // 最后修改时间
	private String createdId; // 创建人
	private String modifiedId; // 修改人

	/**
	 * 列名对应的java属性名
	 */
	private String propName;

	/**
	 * 首字母大写方法名，前面加上set和get
	 */
	private String methodName;

	/**
	 * 列名对应的java复杂属性名
	 */
	private String propNameStr;
	/**
	 * 列名对应的java复杂属性名类型
	 */
	private String propNameStrType;
	/**
	 * 首字母大写复杂方法名，前面加上set和get
	 */
	private String methodNameStr;
	
	private String fieldTypeLowerCase;

	// getter部分
	public String getUuid() {
		return this.uuid;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public String getFieldDescribe() {
		return this.fieldDescribe;
	}

	public int getFieldLength() {
		return this.fieldLength;
	}

	public int getPointLength() {
		return this.pointLength;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public String getFieldDefault() {
		return this.fieldDefault;
	}

	public String getIsKey() {
		return this.isKey;
	}

	public String getIsNull() {
		return this.isNull;
	}

	public String getIsQuery() {
		return this.isQuery;
	}

	public String getIsShow() {
		return this.isShow;
	}

	public String getIsShowList() {
		return this.isShowList;
	}

	public String getShowType() {
		return this.showType;
	}

	public int getShowLength() {
		return this.showLength;
	}

	public String getDataDictionaryType() {
		return this.dataDictionaryType;
	}

	public String getTableUuid() {
		return this.tableUuid;
	}

	public int getOrderNum() {
		return this.orderNum;
	}

	public java.sql.Timestamp getCreatedTime() {
		return this.createdTime;
	}

	// getter部分,Timestamp类型的修改获取String的方法
	public String getCreatedTimeStr() {
		return DateUtils.formatTime(this.createdTime);
	}

	public java.sql.Timestamp getLastModifiedTime() {
		return this.lastModifiedTime;
	}

	// getter部分,Timestamp类型的修改获取String的方法
	public String getLastModifiedTimeStr() {
		return DateUtils.formatTime(this.lastModifiedTime);
	}

	public String getCreatedId() {
		return this.createdId;
	}

	public String getModifiedId() {
		return this.modifiedId;
	}

	// setter部分
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setFieldDescribe(String fieldDescribe) {
		this.fieldDescribe = fieldDescribe;
	}

	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	}

	public void setPointLength(int pointLength) {
		this.pointLength = pointLength;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public void setFieldDefault(String fieldDefault) {
		this.fieldDefault = fieldDefault;
	}

	public void setIsKey(String isKey) {
		this.isKey = isKey;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public void setIsQuery(String isQuery) {
		this.isQuery = isQuery;
	}

	public void setIsShow(String isShow) {
		this.isShow = isShow;
	}

	public void setIsShowList(String isShowList) {
		this.isShowList = isShowList;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public void setShowLength(int showLength) {
		this.showLength = showLength;
	}

	public void setDataDictionaryType(String dataDictionaryType) {
		this.dataDictionaryType = dataDictionaryType;
	}

	public void setTableUuid(String tableUuid) {
		this.tableUuid = tableUuid;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public void setCreatedTime(java.sql.Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public void setCreatedTimeStr(String createdTimeStr) {
		this.createdTimeStr = createdTimeStr;
	}

	public void setLastModifiedTime(java.sql.Timestamp lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public void setLastModifiedTimeStr(String lastModifiedTimeStr) {
		this.lastModifiedTimeStr = lastModifiedTimeStr;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	public void setModifiedId(String modifiedId) {
		this.modifiedId = modifiedId;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getPropNameStr() {
		return propNameStr;
	}

	public void setPropNameStr(String propNameStr) {
		this.propNameStr = propNameStr;
	}

	public String getPropNameStrType() {
		return propNameStrType;
	}

	public void setPropNameStrType(String propNameStrType) {
		this.propNameStrType = propNameStrType;
	}

	public String getMethodNameStr() {
		return methodNameStr;
	}

	public void setMethodNameStr(String methodNameStr) {
		this.methodNameStr = methodNameStr;
	}

	public String getFieldTypeLowerCase() {
		if (fieldType.indexOf(".") != -1) {
			return fieldType;
		} else {
			return fieldType.toLowerCase();
		}
	}

	public void setFieldTypeLowerCase(String fieldTypeLowerCase) {
		this.fieldTypeLowerCase = fieldTypeLowerCase;
	}

}
