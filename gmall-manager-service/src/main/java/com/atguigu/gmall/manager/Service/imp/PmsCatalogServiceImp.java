package com.atguigu.gmall.manager.Service.imp;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.manager.Mapper.PmsBaseCatalog1Mapper;
import com.atguigu.gmall.manager.Mapper.PmsBaseCatalog2Mapper;
import com.atguigu.gmall.manager.Mapper.PmsBaseCatalog3Mapper;
import com.atguigu.gmall.service.PmsCatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsCatalogServiceImp implements PmsCatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {


        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Mapper.selectAll();


        return pmsBaseCatalog1s;
    }
}
