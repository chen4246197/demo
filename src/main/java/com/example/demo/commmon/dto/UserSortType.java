package com.example.demo.commmon.dto;

public enum UserSortType {
    ID_DESC(1,"id"),
    ID_ASC(2,"id"),
    NAME_DESC(3,"userName"),
    NAME_ASC(4,"userName");

    private Integer value;
    private String name;

    UserSortType(Integer value,String name){
        this.value = value;
        this.name = name;
    }
}
