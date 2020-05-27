package com.tian.demo.dao;

import com.tian.demo.model.PageModel;
import com.tian.demo.model.Parameter;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 参数配置表DAO
 * <b>功能：</b>ParameterDao<br>
 * <b>作者：</b>CodeGenerater<br>
 * <b>日期：</b>2016-04-01 15:36:07<br>
 * <b>版权所有：<b>天瑞兴隆<br>
 */
@Repository
public class ParameterDao  {

    public void save(Parameter obj) {
    }

    public void update(Parameter obj) {
    }

    public void saveOrUpdate(Parameter obj) {
    }

    public void saveOrUpdateAll(List<Parameter> objs) {
    }

    public void delete(Parameter tableById) {
    }

    public void deleteAll(List<Parameter> objs) {
    }

    public int excuteBySql(String queryString, Object[] values) {
        return 1;
    }

    public List<Parameter> find(String queryString, Object[] values, Object o) {
        return null;
    }

    public Parameter get(Integer id) {
        return null;
    }

    public List<Parameter> findByHql(String queryString, Object[] values, PageModel page) {
        return null;
    }

    public List<Parameter> getAll(Object o) {
        return null;
    }
}
