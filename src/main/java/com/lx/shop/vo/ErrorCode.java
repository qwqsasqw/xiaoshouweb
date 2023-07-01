package com.lx.shop.vo;

public enum ErrorCode {
    PARAMS_ERROR(100101, "参数错误"),
    SESSION_TIME_OUT(10102, "会话超时"),
    NO_PERMISSIONS(10103, "无访问权限"),
    NO_LOGIN(10104, "未登录"),
    USER_PWD_ERROR(10105, "用户名或密码错误"),
    ACCOUNT_EXIST(10106, "用户名已存在"),
    ACCOUNT_NOT_EXIST(10107, "用户名不存在"),
    USER_NAME_PWD_ERROR(10108, "用户名或密码错误"),
    USER_NOT_EXIST(10109, "用户不存在"),
    TOKEN_ERROR(10110, "Token错误"),
    LOGIN_ED(10111, "用户已登录"),
    EMAIL_NOT_EXIST(10112, "邮箱不存在"),
    INTERNAL_SERVER_ERROR(10113, "上传失败"),
    GOODS_IS_EXIST(10114, "商品已存在");;

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
