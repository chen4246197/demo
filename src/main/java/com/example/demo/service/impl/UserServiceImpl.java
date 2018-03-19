package com.example.demo.service.impl;

import com.example.demo.commmon.dto.UserSortType;
import com.example.demo.dto.UserVo;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    public static List<UserInfo> userList = new ArrayList<>();

    static {
        UserInfo user1 = new UserInfo(1L,"andy","","");
        UserInfo user2 = new UserInfo(2L,"carl","","Carl");
        UserInfo user3 = new UserInfo(3L,"bruce","","Bruce");
        UserInfo user4 = new UserInfo(4L,"dolly","","Dolly");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

    @Override
    public List<UserVo> getUserList(Long userId, String userName, UserSortType sortType) {
        List<UserVo> userVoList = new ArrayList<>();
        if(CollectionUtils.isEmpty(userList)){
            return userVoList;
        }
        List<UserInfo> userDoList = userList.stream()
                .filter(userInfo -> userId == null?true:userInfo.getId().equals(userId))
                .filter(userInfo -> userName == null?true:userInfo.getName().contains(userName))
                .collect(Collectors.toList());

        if(CollectionUtils.isEmpty(userDoList)){
            return userVoList;
        }
        for (UserInfo userInfo : userDoList) {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userInfo,userVo);
            userVoList.add(userVo);
        }
        if(null == sortType){
            sortType = UserSortType.ID_DESC;
        }
        Comparator<UserVo> nameComparator = Comparator.comparing(UserVo::getName);
        Comparator<UserVo> idComparator = Comparator.comparing(UserVo::getId);
        switch (sortType){
            case ID_ASC:
                userVoList = userVoList.stream().sorted(idComparator.reversed()).collect(Collectors.toList());
                break;
            case ID_DESC:
                userVoList = userVoList.stream().sorted(idComparator).collect(Collectors.toList());
                break;
            case NAME_ASC:
                userVoList = userVoList.stream().sorted(nameComparator.reversed()).collect(Collectors.toList());
                break;
            case NAME_DESC:
                userVoList = userVoList.stream().sorted(nameComparator).collect(Collectors.toList());
                break;
        }

        return userVoList;
    }
}
