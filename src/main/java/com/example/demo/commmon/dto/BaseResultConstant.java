package com.example.demo.commmon.dto;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseResultConstant {
    private static final Map<Integer, BaseResultConstant> resultMap = new ConcurrentHashMap();
    public static final BaseResultConstant SUCCESS = new BaseResultConstant(1000, "success");
    private int resultCode;
    private String description;

    public BaseResultConstant(int resultCode, String description) {
        this.resultCode = resultCode;
        this.description = description;
        resultMap.put(resultCode, this);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getDescription() {
        return this.description;
    }

    public static BaseResultConstant getResult(int resultCode) {
        return (BaseResultConstant)resultMap.get(resultCode);
    }
}