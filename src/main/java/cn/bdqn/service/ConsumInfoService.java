package cn.bdqn.service;

import cn.bdqn.pojo.ConsumInfo;

import java.util.List;

public interface ConsumInfoService {
    /**
     * 根据手机号获取消费记录
     * @param cardNumber
     * @return
     */
    List<ConsumInfo> getByConsumInfoCardNumber(String cardNumber);

    /**
     * 添加消费记录
     * @param consumInfo
     * @return
     */
    Integer addConsumInfo(ConsumInfo consumInfo);
}
