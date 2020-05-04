package com.atguigu.gmall.manager.Service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.manager.Mapper.PmsBaseCatalog3Mapper;
import com.atguigu.gmall.service.PmsCatalogService3;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsCatalogServiceImp3 implements PmsCatalogService3 {

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();

        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;
    }
}
