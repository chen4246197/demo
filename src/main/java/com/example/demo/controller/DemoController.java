package com.example.demo.controller;

import com.example.demo.commmon.dto.UserSortType;
import com.example.demo.dto.Demo;
import com.example.demo.dto.UserVo;
import com.example.demo.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenm
 * @create 2017-12-18 下午2:58
 * @desc
 **/
@Controller
@RequestMapping("/user")
public class DemoController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String demo(Long id, String name, UserSortType userSortType,Model model){
        List<UserVo> list = userService.getUserList(id,name,userSortType);
        model.addAttribute("userList",list);
        return "/index";

    }




}
