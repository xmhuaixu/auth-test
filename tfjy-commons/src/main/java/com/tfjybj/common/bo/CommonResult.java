package com.tfjybj.common.bo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * User: Banana
 * Date: 2020/5/26
 * Time: 8:05
 * DingDing: 17731618462
 * Description: 后端向前端返回得实体类
 **/

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CommonResult {

    public static final String SUCCESS = "0000";
    public static final String FAIL = "1111";

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    private Object data;

    private Exception exception;


    private CommonResult() {
        super();
    }

    private CommonResult(String code, String msg) {
        super();
        this.code = code;
        this.message = msg;
    }

    private CommonResult(String code, String msg, Object data) {
        super();
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    private CommonResult(String code, String msg, Exception exception) {
        super();
        this.code = code;
        this.message = msg;
        this.exception = exception;
    }

    public static CommonResult build(String code, String msg, Object data) {
        return new CommonResult(code, msg, data);
    }

    public static CommonResult build(String code, String msg) {
        return new CommonResult(code, msg);
    }

    public static CommonResult build(String code, String msg, Exception e) {
        return new CommonResult(code, msg, e);
    }

}