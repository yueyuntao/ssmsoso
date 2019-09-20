package cn.bdqn.service;

import cn.bdqn.pojo.Packages;

import java.util.List;

public interface PackageService {

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
    Packages getByPackagePaId(Integer paId);
}
