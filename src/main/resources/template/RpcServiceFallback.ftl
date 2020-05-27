/*
 *  Copyright 2012, Tera-soft Co., Ltd.  All right reserved.
 *
 *  THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF TERA-SOFT CO.,
 *  LTD.  THE CONTENTS OF THIS FILE MAY NOT BE DISCLOSED TO THIRD
 *  PARTIES, COPIED OR DUPLICATED IN ANY FORM, IN WHOLE OR IN PART,
 *  WITHOUT THE PRIOR WRITTEN PERMISSION OF TERA-SOFT CO., LTD
 *
 */
package ${bizzPackage}.${modelPackage}.rpc.impl;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ${bizzPackage}.${modelPackage}.model.${className};
import ${bizzPackage}.${modelPackage}.rpc.${className}RpcService;

import com.common.base.model.ResultResponse;


/**
 * 
 * ${tableComment}
 * <b>功能：</b>${className}RpcServiceFallback<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b>${createDate}<br>
 * <b>版权所有：<b>${copyRight}<br>
 */
@Component
public class ${className}RpcServiceFallback implements ${className}RpcService{

	/**
	 * 显示${tableComment}的查询列表
	 * @param params
	 * @return
	 */
	public ResultResponse List(@RequestParam Map<String, Object> params) {
		ResultResponse resultResponse = null;
		return resultResponse;
	}
	
	/**
	 * 获取${tableComment}分页总数
	 * @param params
	 * @return
	 */
    public ResultResponse getCount(@RequestParam Map<String, Object> params) {
		ResultResponse resultResponse = null;
		return resultResponse;
	}

	/**
	 * 保存${tableComment}数据
	 * @param bean
	 * @return
	 */
	public ResultResponse save(@RequestBody ${className} bean) {
		ResultResponse resultResponse = null;
		return resultResponse;
	}

	/**
	 * 删除${tableComment}数据
	 * @param id
	 * @return
	 */
	public ResultResponse remove(@PathVariable Object id) {
		ResultResponse resultResponse = null;
		return resultResponse;
	}
	
	/**
	 * 获取${tableComment}数据
	 * @param id
     * @return
	 */
	public ResultResponse get(@PathVariable Object id) {
		ResultResponse resultResponse = null;
		return resultResponse;
	}

}
