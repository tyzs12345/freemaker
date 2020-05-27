package com.tian.demo.service;

import java.util.List;
import java.util.Map;

import com.tian.demo.dao.TableDao;
import com.tian.demo.model.Field;
import com.tian.demo.model.PageModel;
import com.tian.demo.model.Table;
import com.tian.demo.util.CodeGeneraterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 代码生成_表信息服务类
 * <b>功能：</b>TableDao<br>
 * <b>作者：</b>CodeGenerater<br>
 * <b>日期：</b>2017-01-18 17:13:27<br>
 * <b>版权所有：<b>天瑞兴隆<br>
 */
@Slf4j
@Service("tableService")
public class TableService {

	@Autowired(required=false)
	private TableDao dao;
	@Autowired(required=false)
	private FieldService fieldService;

	@Transactional
	public void add(Table... objs)  throws Exception {
		if(objs == null || objs.length < 1){
			return;
		}
		for(Table obj : objs ){
			dao.save(obj);
			Field field = new Field();
			field.setFieldName("uuid");
			field.setFieldDescribe("主键");
			field.setFieldLength(32);
			field.setFieldType("String");
			field.setIsKey("Y");
			field.setIsNull("N");
			field.setIsQuery("N");
			field.setIsShow("N");
			field.setIsShowList("N");
			field.setOrderNum(1);
			field.setTableUuid(obj.getUuid());
			field.setCreatedId(obj.getCreatedId());
			field.setCreatedTime(obj.getCreatedTime());
			field.setLastModifiedTime(obj.getLastModifiedTime());
			field.setModifiedId(obj.getModifiedId());
			fieldService.add(field);
			field = new Field();
			field.setFieldName("created_time");
			field.setFieldDescribe("创建时间");
			field.setFieldLength(0);
			field.setFieldType("Timestamp");
			field.setIsKey("N");
			field.setIsNull("Y");
			field.setIsQuery("N");
			field.setIsShow("N");
			field.setIsShowList("N");
			field.setOrderNum(96);
			field.setTableUuid(obj.getUuid());
			field.setCreatedId(obj.getCreatedId());
			field.setCreatedTime(obj.getCreatedTime());
			field.setLastModifiedTime(obj.getLastModifiedTime());
			field.setModifiedId(obj.getModifiedId());
			fieldService.add(field);
			field = new Field();
			field.setFieldName("last_modified_time");
			field.setFieldDescribe("最后修改时间");
			field.setFieldLength(0);
			field.setFieldType("Timestamp");
			field.setIsKey("N");
			field.setIsNull("Y");
			field.setIsQuery("N");
			field.setIsShow("N");
			field.setIsShowList("N");
			field.setOrderNum(97);
			field.setTableUuid(obj.getUuid());
			field.setCreatedId(obj.getCreatedId());
			field.setCreatedTime(obj.getCreatedTime());
			field.setLastModifiedTime(obj.getLastModifiedTime());
			field.setModifiedId(obj.getModifiedId());
			fieldService.add(field);
			field = new Field();
			field.setFieldName("created_id");
			field.setFieldDescribe("创建人");
			field.setFieldLength(32);
			field.setFieldType("String");
			field.setIsKey("N");
			field.setIsNull("Y");
			field.setIsQuery("N");
			field.setIsShow("N");
			field.setIsShowList("N");
			field.setOrderNum(98);
			field.setTableUuid(obj.getUuid());
			field.setCreatedId(obj.getCreatedId());
			field.setCreatedTime(obj.getCreatedTime());
			field.setLastModifiedTime(obj.getLastModifiedTime());
			field.setModifiedId(obj.getModifiedId());
			fieldService.add(field);
			field = new Field();
			field.setFieldName("modified_id");
			field.setFieldDescribe("修改人");
			field.setFieldLength(32);
			field.setFieldType("String");
			field.setIsKey("N");
			field.setIsNull("Y");
			field.setIsQuery("N");
			field.setIsShow("N");
			field.setIsShowList("N");
			field.setOrderNum(99);
			field.setTableUuid(obj.getUuid());
			field.setCreatedId(obj.getCreatedId());
			field.setCreatedTime(obj.getCreatedTime());
			field.setLastModifiedTime(obj.getLastModifiedTime());
			field.setModifiedId(obj.getModifiedId());
			fieldService.add(field);
		}
	}
	
	@Transactional
	public void update(Table obj)  throws Exception {
		dao.update(obj);
	}
	
	@Transactional
	public void saveOrUpdate(Table obj)  throws Exception {
		dao.saveOrUpdate(obj);
	}
	
	@Transactional
	public void saveOrUpdateAll(List<Table> objs)  throws Exception {
		dao.saveOrUpdateAll(objs);
	}
	
	@Transactional
	public void delete(Object... ids) throws Exception {
		if(ids == null || ids.length < 1){
			return;
		}
		for(Object id : ids ){
			if (null != id && !"".equals(id)) {
				dao.delete(getTableById(id.toString()));
			}
		}
	}
	
	@Transactional
	public void delete(Table obj) throws Exception {
		dao.delete(obj);
	}
	
	@Transactional
	public void deleteAll(List<Table> objs) throws Exception {
		dao.deleteAll(objs);
	}
	
	@Transactional
	public int excuteBySql(String queryString, Object[] values) {
        return dao.excuteBySql(queryString, values);
    }
    
    public List<Table> find(String queryString, Object[] values) {
        return dao.find(queryString, values, null);
    }
    
    public List<Table> find(String queryString, Object[] values, PageModel page) {
        return dao.find(queryString, values, page);
    }
    
    public List<Table> findByHql(String queryString, Object[] values, PageModel page) {
    	return dao.findByHql(queryString, values, page);
    }
    
    public Table getTableById(String id) {
    	return dao.get(id);
    }
    
    public List<Table> getAllTable() {
        return dao.getAll(null);
    }
    
    public List<Table> getAll(PageModel page) {
        return dao.getAll(page);
    }
    

	/**
	 * 代码生成
	 * @param uuid
	 * @param
	 * @return
	 */
	/*public String codeGenerater(String uuid, Map paraMap){

		String modelPackage = (String)paraMap.get("modelPackage");
		String jspPath = (String)paraMap.get("jspPath");
		String startsWithStr = (String)paraMap.get("startsWithStr");
		String daoType = (String)paraMap.get("daoType");
		String uiType = (String)paraMap.get("uiType");
		String dbType = (String)paraMap.get("dbType");
		
		String zipPath = CodeGeneraterUtil.codeGenerater(uuid, modelPackage, jspPath, startsWithStr, daoType, uiType, dbType);
		
		return zipPath;
	}*/
}
