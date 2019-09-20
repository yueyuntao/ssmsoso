package cn.bdqn.service;

import cn.bdqn.dao.ConsumInfoMapper;
import cn.bdqn.pojo.ConsumInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("consumInfoService")
public class ConsumInfoServiceImpl implements ConsumInfoService {

    @Resource
    private ConsumInfoMapper consumInfoMapper;


    @Override
    public Integer addConsumInfo(ConsumInfo consumInfo) {
        Integer integer=null;
        try {
            integer = consumInfoMapper.addConsumInfo(consumInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public List<ConsumInfo> getByConsumInfoCardNumber(String cardNumber) {
        List<ConsumInfo> infoList=null;
        try {
            infoList = consumInfoMapper.getByConsumInfoCardNumber(cardNumber);
        }catch (Exception e){
            e.printStackTrace();
        }
        return infoList;
    }
}
