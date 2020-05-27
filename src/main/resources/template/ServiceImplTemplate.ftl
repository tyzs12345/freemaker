package ${modelPackage}.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.BeanUtils;

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
@Slf4j	
@Service("$!{lowerName}Service")
public class ${className}ServiceImpl implements ${className}Service{


	@Autowired(required=false)
    private ${className}Dao dao;

	@Transactional
	public int add(${className}... objs)
    {
        int num = 0;
        if(objs == null || objs.length < 1){
            return num;
        }
        Instant now = Instant.now();
        String user = UserUtils.getUser();
        for(${className} obj : objs ){
            obj.setId(IdWorker.nextStringId());
            obj.setCreateDttm(now);
            obj.setCreateUser(user);
            obj.setUpdateDttm(now);
            obj.setUpdateUser(user);
            dao.add(obj);
            num++;
        }
        log.info("新增：{}" + num);
        return num;
    }
	
	@Transactional
	public int update(${className} obj)
	{
        int num = dao.update(obj);
        log.info("更新数量：{}",num);
        return num;
	}
	
	@Transactional
	public int updateOnlyChanged(${className} obj)
	{
        int num = dao.updateOnlyChanged(obj);
        log.info("修改数量：{}",num);
        return num;
	}
	
	@Transactional
	public int delete(String... ids)
	{
        int num = 0;
        if(ids == null || ids.length < 1){
            return num;
        }
        for(Object id : ids ){
            dao.delete(id);
        num++;
        }
        log.info("删除数量：{}",num);
        return num;
	}
	
	@Transactional
    public int delete(String id)
	{
        int num = dao.delete(id);
        log.info("删除数量：{}",num);
        return num;
    }

    /**
    * 查询列表总数
    * @param obj
    * @ 
    */
    public int queryCount(${className}QO obj)
    {
        int count = dao.queryCount(obj);
        log.info("列表总数：{}"+count);
        return count;
    }
    /**
    * 查询列表
    * @param obj
    */
    public List<${className}VO> queryList(${className}QO obj)  
    {
        List<${className}> ${lowerName}List = dao.queryList(obj);
        List<${className}VO> responseList = null;
            //实体对象转为vo对象
        if(${lowerName}List != null){
             responseList = new ArrayList<${className}VO>();
             for (${className} model : ${lowerName}List) {
                ${className}VO vo = new ${className}VO();
                BeanUtils.copyProperties(model, vo);
                responseList.add(vo);
            }
        }

        log.info("查询列表结果：{}"+JSONUtil.listToJson(responseList, true));
        return responseList; 
	}


    /**
    * 分页查询结束子广告单信息数据
    * @param obj
    */
    public PageModel<${className}VO> pageQuery(${className}QO obj)  
    {
        log.info("分页查询结束子广告单信息数据：request{}：" + JSONUtil.beanToJson(obj));
        PageHelper.startPage(obj.getPageNum() <= 0 ? 1 : obj.getPageNum(), obj.getPageSize());
        List<${className}> ${lowerName}List = dao.pageQuery(obj);
        PageInfo pageInfo = new PageInfo<>(${lowerName}List);

        //实体对象转为vo对象
        List<${className}VO> responseList = null;
            //实体对象转为vo对象
        if(${lowerName}List != null){
            responseList = new ArrayList<${className}VO>();
            for (${className} model : ${lowerName}List) {
                ${className}VO vo = new ${className}VO();
                BeanUtils.copyProperties(model, vo);
                responseList.add(vo);
            }
        }
        pageInfo.setList(responseList);//返回vo对象
        log.info("分页查询结束子广告单信息数据：request：{}，response：{}" + JSONUtil.beanToJson(obj) + "，" + JSONUtil.beanToJson(PageModel.from(pageInfo)));
        return PageModel.from(pageInfo);
    }

    /**
    * 根据id查询记录
    * @param id
    */
    public ${className}VO queryById(Object id)
	{
        ${className} ${lowerName} = (${className}) dao.queryById(id);
        //实体对象转为vo对象
        ${className}VO vo = new ${className}VO();
            if (${lowerName} != null) {
            BeanUtils.copyProperties(${lowerName}, vo);
        }
        log.info("查询结果：{}"+JSONUtil.beanToJson(vo, true));
        return vo;
    }
	
}


