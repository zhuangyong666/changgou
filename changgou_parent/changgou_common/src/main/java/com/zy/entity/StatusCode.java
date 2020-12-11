package com.zy.entity;

/**
 * 返回码
 */
public enum StatusCode {
    OK(2000, "成功", true),
    ERROR(20001, "失败", false),
    LOGINERROR(20002, "用户名或密码错误", false),
    ACCESSERROR(20003, "权限不足", false),
    REMOTEERROR(20004, "远程调用失败", false),
    REPERROR(20005, "重复操作", false);
    private Integer code;
    private String message;
    private boolean flag;

    StatusCode(Integer code, String message, boolean flag) {
        this.code = code;
        this.message = message;
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isFlag() {
        return flag;
    }
}
