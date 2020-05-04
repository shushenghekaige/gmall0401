package com.atguigu.gmall.manager.Service.imp;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.manager.Mapper.PmsBaseAttrInfoMapper;
import com.atguigu.gmall.manager.Mapper.PmsBaseAttrValueMapper;
import com.atguigu.gmall.service.PmsBaseAttrInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

@Service
public class PmsBaseAttrInfoServiceImp implements PmsBaseAttrInfoService {


    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);

        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        String id = pmsBaseAttrInfo.getId();

        if(StringUtils.isBlank(id)){

            /*id为空*/

            /*保存属性*/
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);

        /*保存属性值*/

            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

            }


        }
        else {
            /*id不为空*/
//           修改属性

            Example example = new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo,example);

//            删除原来的属性值
            PmsBaseAttrValue pmsBaseAttrValueD = new PmsBaseAttrValue();
            pmsBaseAttrValueD.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pmsBaseAttrValueD);

            List<PmsBaseAttrValue> attrValueLists = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue attrValueList : attrValueLists) {


                if (attrValueList.getAttrId()==null){
                    attrValueList.setAttrId(pmsBaseAttrInfo.getId());
                }

                pmsBaseAttrValueMapper.insertSelective(attrValueList);

            }


        }

        return "success";
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);

        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }
}
