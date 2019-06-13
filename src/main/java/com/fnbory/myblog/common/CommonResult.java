package com.fnbory.myblog.common;


public class CommonResult {
    private  long code;
    private  String msg;
    private  Object data;

    public  CommonResult(long code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
