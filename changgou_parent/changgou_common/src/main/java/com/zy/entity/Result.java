package com.zy.entity;

/**
 * 返回结果实体类
 */
public class Result<T> {

    private boolean flag;//是否成功
    private Integer code;//返回码
    private String message;//返回消息
    private T data;//返回数据

    private Result(StatusCode statusCode) {
        this.flag = statusCode.isFlag();
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public Result() {
    }

    public static Result result(Integer total) {
        if (total > 0) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    public static Result success() {
        return new Result(StatusCode.OK);
    }

    public Result addData(Object data) {
        this.data = (T) data;
        return this;
    }

    public static Result fail() {
        return new Result(StatusCode.ERROR);
    }

    public static Result fail(Integer code, String message) {
        Result<Object> result = new Result<>();
        result.setFlag(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result fail(StatusCode statusCode) {
        return new Result(statusCode);
    }

    public boolean isFlag() {
        return flag;
    }

    private void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }
}
