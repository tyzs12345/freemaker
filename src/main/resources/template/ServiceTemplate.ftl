package ${modelPackage}.service;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ${modelPackage}.dao.${className}Dao;
import ${modelPackage}.model.${className};
import ${modelPackage}.qo.${className}QO;
import ${modelPackage}.vo.${className}VO;

/**
 * 
 * ${tableComment}服务类
 * <b>功能：</b>${className}Dao<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b>${createDate}<br>
 * <b>版权所有：<b>${copyRight}<br>
 */

public interface ${className}Service {


	public int add(${className}... objs);

	public int update(${className} obj);

	public int updateOnlyChanged(${className} obj);

	public int delete(Object... ids);

    public int delete(Object id);

    /**
    * 查询列表总数
    * @param obj
    * @
    */
    public int queryCount(${className}QO obj);

    /**
    * 查询列表
    * @param obj
    */
    public List<${className}VO> queryList(${className}QO obj);

    /**
    * 分页查询结束子广告单信息数据
    * @param obj
    */
    public PageModel<${className}VO> pageQuery(${className}QO obj);

    /**
    * 根据id查询记录
    * @param id
    */
    public ${className}VO queryById(Object id);


    }
