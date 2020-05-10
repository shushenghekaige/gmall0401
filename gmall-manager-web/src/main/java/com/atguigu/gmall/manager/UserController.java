package com.atguigu.gmall.manager;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Reference
    UserService userService;

    @RequestMapping("getAllUser")
    public List<UmsMember> getAllUser(){

        List<UmsMember> umsMembers=userService.getAllUser();
        return umsMembers;
    }
}
