package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {


    List<UmsMember> getAll();

    List<UmsMemberReceiveAddress> getAddressByMemberId(String memberId);

    List<UmsMember> getAllUser();
}
