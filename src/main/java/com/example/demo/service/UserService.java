package com.example.demo.service;

import com.example.demo.commmon.dto.UserSortType;
import com.example.demo.dto.UserVo;

import java.util.List;

/**
 * @author cm
 * @create 2018-03-19 14:20
 */
public interface UserService {

    List<UserVo>  getUserList(Long userId,String userName,UserSortType sortType);




}
