package ${modelPackage}.controller;

import ${modelPackage}.model.${className};
import ${modelPackage}.model.vo.${className}QueryVO;
import ${modelPackage}.service.${className}Service;

import com.zero.common.base.constant.ResultResponseConstants;
import com.zero.common.base.model.ResultResponse;
import com.zero.common.base.model.TableResponse;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * 
 * ${tableComment}控制器
 * <b>功能：</b>${className}Controller<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b>${createDate}<br>
 * <b>版权所有：<b>${copyRight}<br>
 */
@Slf4j
@Controller
@RequestMapping("/$!{lowerName}")
public class ${className}Controller {

	/**
	 * ${className}Service
	 */
	@Autowired(required=false) //自动注入
	private ${className}Service ${lowerName}Service;

	
	/**
	 * 
	 * 显示${tableComment}的列表
	 * @param queryVO
	 * @return
	 */
 	@ApiOperation(value="获取${tableComment}列表", notes="")
	@RequestMapping(value = "/pageQuery", method=RequestMethod.POST)
	@ResponseBody
	public TableResponse Page(@RequestBody ${className}VO ${lowerName}QO) {
         String thisMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         log.info("调用方法：" + thisMethodName);
         log.info("查询参数：{}"+JSONUtil.beanToJson($!{lowerName}QO, true));
         return ObjectDataResponse.payload(this.${lowerName}Service.pageQuery($!{lowerName}QO));
	}
    
	/**
	 * 保存${tableComment}数据
	 * @param bean
	 * @return
	 */
	@ApiOperation(value="保存${tableComment}数据", notes="")
	@RequestMapping(value = "/save", method=RequestMethod.POST)
    @ResponseBody
	public ResultResponse save(@RequestBody ${className} bean)
    {
         String thisMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
         log.info("调用方法：" + thisMethodName);
         log.info("保存参数：{}"+JSONUtil.beanToJson(bean, true));
         boolean flag = bean.getId() != null && !"".equals(bean.getId());
         log.info("分支：{}" + bean.getId() + "是否存在："+flag);
         //如果存在
         if (flag) {
             return ObjectDataResponse.payload(this.${lowerName}Service.updateOnlyChanged(bean));
         } else { //如果不存在
             bean.setId(IdWorker.nextStringId());
             return ObjectDataResponse.payload(this.${lowerName}Service.add(bean));
        }
    }

	/**
	 * 删除${tableComment}数据
	 * @param id
     * @return
	 */
	@ApiOperation(value="删除${tableComment}数据", notes="传入数据ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
	public ResultResponse remove(@PathVariable Object id) {
        String thisMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("调用方法：" + thisMethodName);
        log.info("删除决策表Id：{}"+id);
        return ObjectDataResponse.payload(this.${lowerName}Service.delete(id));
	}
	
	/**
	 * 获取${tableComment}数据
	 * @param id
     * @return
	 */
	@ApiOperation(value="获取${tableComment}数据", notes="传入数据ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultResponse get(@PathVariable Object id) {
        String thisMethodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        log.info("调用方法：" + thisMethodName);
        log.info("获取决策表Id：{}"+id);
        return ObjectDataResponse.payload(this.${lowerName}Service.queryById(id));
	}

}
