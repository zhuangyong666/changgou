package com.zy.entity;

/**
 * 返回码
 */
public enum StatusCode {
    OK(200, "成功", true),
    ERROR(201, "失败", false),
    LOGINERROR(202, "用户名或密码错误", false),
    ACCESSERROR(203, "权限不足", false),
    REMOTEERROR(204, "远程调用失败", false),
    REPERROR(205, "重复操作", false),
    SYSTEMERROR(500, "系统异常", false);
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
