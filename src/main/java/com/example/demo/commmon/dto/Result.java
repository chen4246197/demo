package com.example.demo.commmon.dto;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private boolean success;
    private int codeNum;
    private String codeDesc;
    private T value;

    private Result() {
    }

    public static <T> Result<T> ofSuccess(T value) {
        Result<T> result = new Result();
        result.setSuccess(true);
        result.setValue(value);
        return result;
    }

    public static Result ofError(int codeNum, String codeDesc) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCodeNum(codeNum);
        result.setCodeDesc(codeDesc);
        return result;
    }

    public static Result ofError(BaseResultConstant baseResultConstant) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCodeNum(baseResultConstant.getResultCode());
        result.setCodeDesc(baseResultConstant.getDescription());
        return result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCodeNum() {
        return this.codeNum;
    }

    public void setCodeNum(int codeNum) {
        this.codeNum = codeNum;
    }

    public String getCodeDesc() {
        return this.codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String toString() {
        return "Result{success=" + this.success + ", codeNum=" + this.codeNum + ", codeDesc='" + this.codeDesc + '\'' + ", value=" + this.value + '}';
    }
}