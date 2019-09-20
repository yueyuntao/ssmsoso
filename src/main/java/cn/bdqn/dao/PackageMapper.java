package cn.bdqn.dao;

import cn.bdqn.pojo.Packages;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PackageMapper {
    /**
     * 查询显示所有
     * @return
     */
    List<Packages> getPackageList();

    /**
     * 根据ID获取套餐信息
     * @param paId
     * @return
     */
    Packages getByPackagePaId(@Param("paId")Integer paId);

}
