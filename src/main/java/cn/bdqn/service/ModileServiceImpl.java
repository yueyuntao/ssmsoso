package cn.bdqn.service;

import cn.bdqn.dao.ModileMapper;
import cn.bdqn.pojo.Modile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("modileService")
public class ModileServiceImpl implements ModileService {

    @Resource
    private ModileMapper modileMapper;

    @Override
    public Modile getModileByUserNameAndPassWord(String userName, String passWord) {
        Modile modile = null;
        try {
            modile = modileMapper.getModileByUserName(userName);
            if (modile != null && modile.getPassWord().equals(passWord)) {
                return modile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Modile> getModileList() {
        List<Modile> modileList = null;
        try {
            modileList = modileMapper.getModileList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modileList;
    }

    @Override
    public Modile getModileByCardNumber(String cardNumber) {
        Modile modile = null;
        try {
            modile = modileMapper.getModileByCardNumber(cardNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modile;
    }

    @Override
    public Integer updModilePas(Integer paId, Integer id) {
        Integer integer = null;
        try {
            integer = modileMapper.updModilePas(paId, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer updModile(Modile modile) {
        Integer integer = null;
        try {
            integer = modileMapper.updModile(modile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer delModile(Integer id) {
        Integer integer = null;
        try {
            integer = modileMapper.delModile(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer updMoney(String cardNumber, Integer money) {
        Integer integer = null;
        try {
            integer = modileMapper.updMoney(cardNumber, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Integer addModile(Modile modile) {
        Integer integer = null;
        try {
            modile.setMoney(modile.getMoney() - modile.getPas().getPrice());
            integer = modileMapper.addModile(modile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return integer;
    }

    @Override
    public Modile getModileByCardNumberAndPassWord(String cardNumber, String passWord) {
        Modile modile = null;
        try {
            modile = modileMapper.getModileByCardNumber(cardNumber);
            if (modile != null && modile.getPassWord().equals(passWord)) {
                return modile;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Modile getModileByUserName(String userName) {
        Modile modile = null;
        try {
            modile = modileMapper.getModileByUserName(userName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modile;
    }
}
