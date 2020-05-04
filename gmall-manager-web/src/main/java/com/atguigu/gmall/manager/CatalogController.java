package com.atguigu.gmall.manager;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.PmsCatalogService;
import com.atguigu.gmall.service.PmsCatalogService2;
import com.atguigu.gmall.service.PmsCatalogService3;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CatalogController {

    @Reference
    PmsCatalogService pmsCatalogService;

    @Reference
    PmsCatalogService2 pmsCatalogService2;

    @Reference
    PmsCatalogService3 pmsCatalogService3;



// 查询一级目录
    @RequestMapping(value = "getCatalog1",method = RequestMethod.POST)
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(HttpServletResponse Response){


        List<PmsBaseCatalog1> catalog1=pmsCatalogService.getCatalog1();
        Response.setHeader("Access-Control-Allow-Origin", "*");

        return catalog1;

    }
//查询二级目录
    @RequestMapping(value = "getCatalog2",method = RequestMethod.POST)
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id, HttpServletResponse Response){

        List<PmsBaseCatalog2> Catalog2=pmsCatalogService2.getCatalog2(catalog1Id);
        Response.setHeader("Access-Control-Allow-Origin", "*");


        return Catalog2;
    };
//查询三级目录
   @RequestMapping(value = "getCatalog3",method = RequestMethod.POST)
   @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id,HttpServletResponse Response){

       List<PmsBaseCatalog3> pmsBaseCatalog3s=pmsCatalogService3.getCatalog3(catalog2Id);
       Response.setHeader("Access-Control-Allow-Origin", "*");
       return pmsBaseCatalog3s;

   }


}
