package com.atguigu.gmall.user.service;

import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserAddressService {
    List<UmsMemberReceiveAddress> getAddress();

    List<UmsMemberReceiveAddress> getAddress(String memberId);
}
