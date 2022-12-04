package cn.ctbu.demo.vo;

import lombok.Data;

@Data
public class R<T> {
    private Integer code;

    private String msg;

    private T data;
}
