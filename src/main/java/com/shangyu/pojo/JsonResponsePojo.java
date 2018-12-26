package com.shangyu.pojo;

/**
 * 封装后端响应结果的实体类
 */
public class JsonResponsePojo {
    private Integer code;//响应码
    private String text;//对响应码的简单描述 方便前后端联调 并不用于展示给用户
    private Object result;//真正的数据 要展示在前端页面上

    public JsonResponsePojo() {}

    public JsonResponsePojo(Integer code, String text, Object result) {
        this.code = code;
        this.text = text;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JsonResponsePojo{" +
                "code=" + code +
                ", text='" + text + '\'' +
                ", result=" + result +
                '}';
    }
}
