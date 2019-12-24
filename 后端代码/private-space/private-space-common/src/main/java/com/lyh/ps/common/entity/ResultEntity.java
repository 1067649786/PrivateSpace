package com.lyh.ps.common.entity;

public class ResultEntity<T> {

    private T body;

    private String message;

    private Integer statusCode;

    private String status;

    public ResultEntity(){}

    public ResultEntity(T body, String message, Integer statusCode, String status) {
        this.body = body;
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
