package com.atguigu.gmall.manager.Service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.manager.Mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.service.PmsCatalogService2;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class PmsCatalogServiceImp2 implements PmsCatalogService2 {

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {


        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);

        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);
        return pmsBaseCatalog2s;
    }
}
