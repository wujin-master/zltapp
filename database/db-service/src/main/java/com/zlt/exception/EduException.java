package com.zlt.exception;

import com.zlt.utils.ResultCode;

/**
 * 异常类
 */
//使用示例：当查询到的列表为空时，调用异常类
//    if(CollectionUtils.isEmpty(classDTO.getClassDetailList())){
//            throw new EduException(ResultCode.CLASS_NOT_EXIST);
//            }
public class EduException extends RuntimeException {
    private Integer code;
    public EduException(ResultCode resultCode){
        //调用父类的含msg参数的构造方法
        super(resultCode.getMsg());
        this.code = resultCode.getCode();
    }
    public EduException(Integer code,String msg){
        super(msg);
        this.code = code;
    }

}
