package com.zlt.utils;

public class Result<T> {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private String msg;
    private T data;

    //    不携带数据返回
    private Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }
    //    携带数据返回
    private Result(ResultCode resultCode,T data){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public static Result success(){return new Result(ResultCode.SUCCESS);}
    public static Result success(Object data){return new Result(ResultCode.SUCCESS,data);}
    public static Result failure(ResultCode resultCode){return new Result(resultCode);}
}
