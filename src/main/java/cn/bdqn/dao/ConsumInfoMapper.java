package cn.bdqn.dao;

import cn.bdqn.pojo.ConsumInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConsumInfoMapper {

    /**
     * 根据手机号获取消费记录
     * @param cardNumber
     * @return
     */
    List<ConsumInfo> getByConsumInfoCardNumber(@Param("cardNumber")String cardNumber);

    /**
     * 添加消费记录
     * @param consumInfo
     * @return
     */
    Integer addConsumInfo(ConsumInfo consumInfo);
}
