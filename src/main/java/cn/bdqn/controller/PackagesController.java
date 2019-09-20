package cn.bdqn.controller;

import cn.bdqn.pojo.Modile;
import cn.bdqn.pojo.Packages;
import cn.bdqn.service.ModileService;
import cn.bdqn.service.PackageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PackagesController {

    @Resource
    private PackageService packageService;

    @Resource
    private ModileService modileService;

//    @RequestMapping("/index.html")
//    public String index(HttpSession session){
//        List<Packages> packageList = packageService.getPackageList();
//        session.setAttribute("packageList",packageList);
//        List<Modile> modileList = modileService.getModileList();
//        session.setAttribute("modileList",modileList);
//        return "login";
//    }
}
