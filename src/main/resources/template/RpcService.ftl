/*
 *  Copyright 2012, Tera-soft Co., Ltd.  All right reserved.
 *
 *  THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF TERA-SOFT CO.,
 *  LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED TO THIRD
 *  PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 *  WITHOUT THE PRIOR WRITTEN PERMISSION OF TERA-SOFT CO., LTD
 *
 */
package ${bizzPackage}.${modelPackage}.rpc;

import com.common.base.model.ResultResponse;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import ${bizzPackage}.${modelPackage}.model.${className};
import ${bizzPackage}.${modelPackage}.rpc.impl.${className}RpcServiceFallback;

import java.util.Map;

/**
 * 
 * ${tableComment}控制器
 * <b>功能：</b>${className}Controller<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b>${createDate}<br>
 * <b>版权所有：<b>${copyRight}<br>
 */
@FeignClient(name="", fallback = ${className}RpcServiceFallback.class)
public interface ${className}RpcService {

	/**
	 * 显示${tableComment}的查询列表
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/${jspPath}/list", method=RequestMethod.GET)
	@ResponseBody
	ResultResponse List(@RequestParam Map<String, Object> params);
	
	/**
	 * 获取${tableComment}分页总数
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "/${jspPath}/count", method = RequestMethod.GET)
    @ResponseBody
    ResultResponse getCount(@RequestParam Map<String, Object> params);

	/**
	 * 保存${tableComment}数据
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/${jspPath}/save", method=RequestMethod.POST)
    @ResponseBody
	ResultResponse save(@RequestBody ${className} bean);

	/**
	 * 删除${tableComment}数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/${jspPath}/{id}", method = RequestMethod.DELETE)
    @ResponseBody
	ResultResponse remove(@PathVariable(value="id") Object id);
	
	/**
	 * 获取${tableComment}数据
	 * @param id
     * @return
	 */
	@RequestMapping(value = "/${jspPath}/{id}", method = RequestMethod.GET)
	@ResponseBody
	ResultResponse get(@PathVariable(value="id") Object id);

}
