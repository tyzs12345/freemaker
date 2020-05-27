package com.tian.demo.service;

import java.util.List;

import com.tian.demo.dao.ParameterDao;
import com.tian.demo.model.PageModel;
import com.tian.demo.model.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("parameterService")
public class ParameterService
{

  @Autowired(required=false)
  private ParameterDao dao;

  @Transactional
  public void add(Parameter[] objs) throws Exception { if ((objs == null) || (objs.length < 1)) {
      return;
    }
    for (Parameter obj : objs)
      this.dao.save(obj); }

  @Transactional
  public void update(Parameter obj) throws Exception
  {
    this.dao.update(obj);
  }
  @Transactional
  public void saveOrUpdate(Parameter obj) throws Exception {
    this.dao.saveOrUpdate(obj);
  }
  @Transactional
  public void saveOrUpdateAll(List<Parameter> objs) throws Exception {
    this.dao.saveOrUpdateAll(objs);
  }
  @Transactional
  public void delete(Object[] ids) throws Exception {
    if ((ids == null) || (ids.length < 1)) {
      return;
    }
    for (Object id : ids)
      if ((id != null) && (!"".equals(id)))
        this.dao.delete(getParameterById(Integer.valueOf(Integer.parseInt(id.toString()))));
  }

  @Transactional
  public void delete(Parameter obj) throws Exception
  {
    this.dao.delete(obj);
  }
  @Transactional
  public void deleteAll(List<Parameter> objs) throws Exception {
    this.dao.deleteAll(objs);
  }
  @Transactional
  public int excuteBySql(String queryString, Object[] values) {
    return this.dao.excuteBySql(queryString, values);
  }

  public List<Parameter> find(String queryString, Object[] values) {
    return this.dao.find(queryString, values, null);
  }

  public List<Parameter> find(String queryString, Object[] values, PageModel page) {
    return this.dao.find(queryString, values, page);
  }

  public List<Parameter> findByHql(String queryString, Object[] values, PageModel page) {
    return this.dao.findByHql(queryString, values, page);
  }

  public Parameter getParameterById(Integer id) {
    return (Parameter)this.dao.get(id);
  }

  public List<Parameter> getAllParameter() {
    return this.dao.getAll(null);
  }

  public List<Parameter> getAll(PageModel page) {
    return this.dao.getAll(page);
  }

  public Parameter queryByParamName(String codeGeneraterFilePath) {
    return null;
  }
}