package cn.bdqn.dao;

import cn.bdqn.pojo.Modile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ModileMapper {

    /**
     * 显示所有
     * @return
     */
    List<Modile> getModileList();

    /**
     * 根据名称查询对象
     * @param userName
     * @return
     */
    Modile getModileByUserName(@Param("userName") String userName);

    /**
     * 根据手机号码查询对象
     * @param cardNumber
     * @return
     */
    Modile getModileByCardNumber(@Param("cardNumber") String cardNumber);

    /**
     * 注册用户
     * @param modile
     * @return
     */
    Integer addModile(Modile modile);

    /**
     *话费充值
     * @param cardNumber
     * @param money
     * @return
     */
    Integer updMoney(@Param("cardNumber") String cardNumber,
                     @Param("money")Integer money);

    /**
     * 套餐变更办理
     * @param paId
     * @return
     */
    Integer updModilePas(@Param("paId") Integer paId,
                         @Param("id") Integer id);

    /**
     * 退网办理
     * @param id
     * @return
     */
    Integer delModile(@Param("id") Integer id);

    /**
     * 修改用户信息
     * @param modile
     * @return
     */
    Integer updModile(Modile modile);
}
