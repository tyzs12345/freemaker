package com.tian.demo.model;

import com.tian.demo.util.DateUtils;

import java.io.Serializable;


/**
 * 
 * 代码生成_表信息实体类
 * <b>功能：</b>TableDao<br>
 * <b>作者：</b>CodeGenerater<br>
 * <b>日期：</b>2017-01-18 17:13:27<br>
 * <b>版权所有：<b>天瑞兴隆<br>
 */
public class Table implements Serializable {

	//属性部分
	private String uuid; //主键
	private String tableName; //表名
	private String tableDescribe; //表描述
	private String isGenerater; //是否已生成
	private java.sql.Timestamp createdTime; //创建时间
	private String createdTimeStr; //创建时间
	private java.sql.Timestamp lastModifiedTime; //最后修改时间
	private String lastModifiedTimeStr; //最后修改时间
	private String createdId; //创建人
	private String modifiedId; //修改人

	//getter部分
	public String getUuid () {
		return this.uuid;
	}
	public String getTableName () {
		return this.tableName;
	}
	public String getTableDescribe () {
		return this.tableDescribe;
	}
	public String getIsGenerater () {
		return this.isGenerater;
	}
	public java.sql.Timestamp getCreatedTime () {
		return this.createdTime;
	}
	//getter部分,Timestamp类型的修改获取String的方法
	public String getCreatedTimeStr () {
		return DateUtils.formatTime(this.createdTime);
	}
	public java.sql.Timestamp getLastModifiedTime () {
		return this.lastModifiedTime;
	}
	//getter部分,Timestamp类型的修改获取String的方法
	public String getLastModifiedTimeStr () {
		return DateUtils.formatTime(this.lastModifiedTime);
	}
	public String getCreatedId () {
		return this.createdId;
	}
	public String getModifiedId () {
		return this.modifiedId;
	}

	//setter部分
	public void setUuid (String uuid) {
		this.uuid=uuid;
	}
	public void setTableName (String tableName) {
		this.tableName=tableName;
	}
	public void setTableDescribe (String tableDescribe) {
		this.tableDescribe=tableDescribe;
	}
	public void setIsGenerater (String isGenerater) {
		this.isGenerater=isGenerater;
	}
	public void setCreatedTime (java.sql.Timestamp createdTime) {
		this.createdTime=createdTime;
	}
	public void setCreatedTimeStr (String createdTimeStr) {
		this.createdTimeStr=createdTimeStr;
	}
	public void setLastModifiedTime (java.sql.Timestamp lastModifiedTime) {
		this.lastModifiedTime=lastModifiedTime;
	}
	public void setLastModifiedTimeStr (String lastModifiedTimeStr) {
		this.lastModifiedTimeStr=lastModifiedTimeStr;
	}
	public void setCreatedId (String createdId) {
		this.createdId=createdId;
	}
	public void setModifiedId (String modifiedId) {
		this.modifiedId=modifiedId;
	}

}

