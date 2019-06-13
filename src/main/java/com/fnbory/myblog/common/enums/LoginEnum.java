package com.fnbory.myblog.common.enums;




public enum LoginEnum {
    SUCCESS(true,"登陆成功"),
    FALSE(false,"帐号或密码错误");

    private  boolean result;
    private  String message;

    private LoginEnum(boolean result,String message){
        this.result=result;
        this.message=message;
    }

    public boolean getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

}
