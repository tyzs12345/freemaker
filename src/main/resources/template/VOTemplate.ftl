package ${modelPackage}.model;

import java.io.Serializable;

//${importString}


/**
 * 
 * ${tableComment}实体类
 * <b>功能：</b>${className}<br>
 * <b>作者：</b>${author}<br>
 * <b>日期：</b>${createDate}<br>
 * <b>版权所有：<b>${copyRight}<br>
 */
@Data
public class ${className}VO implements Serializable {

	//属性部分
#foreach($item in $!{columnDatas})
	private $!item.propType $!item.propName; //$!item.columnComment
#end


}

