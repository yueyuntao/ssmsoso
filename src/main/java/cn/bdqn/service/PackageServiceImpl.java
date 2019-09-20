package cn.bdqn.service;

import cn.bdqn.dao.PackageMapper;
import cn.bdqn.pojo.Packages;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("packageService")
public class PackageServiceImpl implements PackageService {

    @Resource
    private PackageMapper packageMapper;

    @Override
    public Packages getByPackagePaId(Integer paId) {
        Packages packages = null;
        try {
            packages = packageMapper.getByPackagePaId(paId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packages;
    }

    @Override
    public List<Packages> getPackageList() {
        List<Packages> packagesList = null;
        try {
            packagesList = packageMapper.getPackageList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packagesList;
    }
}
