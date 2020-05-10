package com.atguigu.gmall.user.mapper;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UmsMemberReceiveAddressMapper {
    List<UmsMemberReceiveAddress> selectAddressByMemberId(String memberId);
}
