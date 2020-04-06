package com.atguigu.gmall.user.controller;


import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.service.UserAddressService;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("getAll")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers=userService.getAll();

        return umsMembers;
    }

    @RequestMapping("getAddressByMemberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAddressByMemberId(String memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses=userService.getAddressByMemberId(memberId);

        return umsMemberReceiveAddresses;

    }


    @Autowired
    UserAddressService userAddressService;

    @RequestMapping("getAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getAddress(String memberId){

        List<UmsMemberReceiveAddress> umsMemberReceiveAddressess=userAddressService.getAddress(memberId);

        return umsMemberReceiveAddressess;
    }




}
