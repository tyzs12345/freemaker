package ${modelPackage}.dao;

import java.util.List;
import java.util.Map;

import ${modelPackage}.model.${className};

/**
 * 
 * ${tableComment}DAO
 * <b>功能：</b>${className}Dao<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b>${createDate}<br>
 * <b>版权所有：<b>${copyRight}<br>
 */
public interface ${className}Dao {
		
	public int add(${className} obj);
	
	public int update(${className} obj);
	
	public int updateOnlyChanged(${className} obj);
		
	public int delete(Object obj);

	public int queryCount(${className}QO obj);
	
	public List<${className}> queryList(${className}QO obj);

	public ${className} queryById(Object obj);

}
