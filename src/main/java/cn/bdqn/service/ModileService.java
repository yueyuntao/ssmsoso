package cn.bdqn.service;

import cn.bdqn.pojo.Modile;

import java.util.List;

public interface ModileService {

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
    Modile getModileByUserName(String userName);

    /**
     * 登录验证
     * @param userName
     * @param passWord
     * @return
     */
    Modile getModileByUserNameAndPassWord(String userName,String passWord);

    /**
     * 根据手机号获取对象
     * @param cardNumber
     * @return
     */
    Modile getModileByCardNumber(String cardNumber);

    /**
     * 登录验证
     * @param cardNumber
     * @param passWord
     * @return
     */
    Modile getModileByCardNumberAndPassWord(String cardNumber,String passWord);

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
    Integer updMoney(String cardNumber, Integer money);

    /**
     * 套餐变更办理
     * @param paId
     * @return
     */
    Integer updModilePas(Integer paId, Integer id);

    /**
     * 退网办理
     * @param id
     * @return
     */
    Integer delModile(Integer id);

    /**
     * 修改用户信息
     * @param modile
     * @return
     */
    Integer updModile(Modile modile);
}
