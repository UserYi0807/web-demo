package cn.ctbu.demo.exception;

import javax.persistence.criteria.CriteriaBuilder;

public enum REnum {
    UNKNOWN_ERR(-999, "未知错误"),
    COMMON_ERR(-10, "一般错误"),
    LOGIN_ERR(-2, "出错，错误用户名或密码"),
    SUCCESS(1, "成功");

    private Integer code;
    private String msg;

    REnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
