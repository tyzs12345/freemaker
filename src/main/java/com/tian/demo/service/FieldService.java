package com.tian.demo.service;

import java.util.List;

import com.tian.demo.dao.FieldDao;
import com.tian.demo.model.Field;
import com.tian.demo.model.PageModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 代码生成_表字段信息服务类
 * <b>功能：</b>FieldDao<br>
 * <b>作者：</b>CodeGenerater<br>
 * <b>日期：</b>2017-01-18 17:51:51<br>
 * <b>版权所有：<b>天瑞兴隆<br>
 */
@Slf4j
@Service("fieldService")
public class FieldService {


	@Autowired(required=false)
	private FieldDao dao;

	@Transactional
	public void add(Field... objs)  throws Exception {
		if(objs == null || objs.length < 1){
			return;
		}
		for(Field obj : objs ){
			dao.save(obj);
		}
	}
	
	@Transactional
	public void update(Field obj)  throws Exception {
		dao.update(obj);
	}
	
	@Transactional
	public void saveOrUpdate(Field obj)  throws Exception {
		dao.saveOrUpdate(obj);
	}
	
	@Transactional
	public void saveOrUpdateAll(List<Field> objs)  throws Exception {
		dao.saveOrUpdateAll(objs);
	}
	
	@Transactional
	public void delete(Object... ids) throws Exception {
		if(ids == null || ids.length < 1){
			return;
		}
		for(Object id : ids ){
			if (null != id && !"".equals(id)) {
				dao.delete(getFieldById(id.toString()));
			}
		}
	}
	
	@Transactional
	public void delete(Field obj) throws Exception {
		dao.delete(obj);
	}
	
	@Transactional
	public void deleteAll(List<Field> objs) throws Exception {
		dao.deleteAll(objs);
	}
	
	@Transactional
	public int excuteBySql(String queryString, Object[] values) {
        return dao.excuteBySql(queryString, values);
    }
    
    public List<Field> find(String queryString, Object[] values) {
        return dao.find(queryString, values, null);
    }
    
    public List<Field> find(String queryString, Object[] values, PageModel page) {
        return dao.find(queryString, values, page);
    }
    

    public Field getFieldById(String id) {
    	return dao.get(id);
    }
    
    public List<Field> getAllField() {
        return dao.getAll(null);
    }
    
    public List<Field> getAll(PageModel page) {
        return dao.getAll(page);
    }


	public List<Field> findByCriteria(Field criteria) {
		return null;
	}
}
