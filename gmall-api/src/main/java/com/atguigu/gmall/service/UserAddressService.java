package com.atguigu.gmall.service;




import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserAddressService {
    List<UmsMemberReceiveAddress> getAddress();

    List<UmsMemberReceiveAddress> getAddress(String memberId);
}
