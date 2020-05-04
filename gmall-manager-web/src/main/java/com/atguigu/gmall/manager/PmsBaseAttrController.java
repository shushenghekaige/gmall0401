package com.atguigu.gmall.manager;
import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.service.PmsBaseAttrInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@CrossOrigin
public class PmsBaseAttrController {

    @Reference
    PmsBaseAttrInfoService pmsBaseAttrInfoService;

    @RequestMapping(value="saveAttrInfo",method = RequestMethod.POST)
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo, HttpServletResponse response){

        String success= pmsBaseAttrInfoService.saveAttrInfo(pmsBaseAttrInfo);

     return "success";

    }


    @RequestMapping(value="getAttrValueList",method = RequestMethod.POST)
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> pmsBaseAttrValues=pmsBaseAttrInfoService.getAttrValueList(attrId);

        return pmsBaseAttrValues;
    }

    /*查询某种产品的属性*/

    @RequestMapping(value ="attrInfoList",method = RequestMethod.GET)
    @ResponseBody
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id, HttpServletResponse response){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos=pmsBaseAttrInfoService.attrInfoList(catalog3Id);
        response.setHeader("Access-Control-Allow-Origin", "*");
        return pmsBaseAttrInfos;

    }



}
