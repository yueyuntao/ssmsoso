package cn.bdqn.controller;

import cn.bdqn.pojo.ConsumInfo;
import cn.bdqn.pojo.Modile;
import cn.bdqn.pojo.Packages;
import cn.bdqn.service.ConsumInfoService;
import cn.bdqn.service.ModileService;
import cn.bdqn.service.PackageService;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class ModileController {


    @Resource
    private ModileService modileService;

    @Resource
    private PackageService packageService;

    @Resource
    private ConsumInfoService consumInfoService;

    //跳转使用嗖嗖页面
    @RequestMapping("/showSoso.html")
    public String showSoso(HttpSession session) {
        if (session.getAttribute("modile") == null) {
            return "login";
        }
        return "showSoso";
    }

    /**
     * 使用嗖嗖
     *
     * @param session
     * @return
     */
    @RequestMapping("/showSoso")
    @ResponseBody
    public Object showSoso_01(HttpSession session) {
        Modile modile = (Modile)session.getAttribute("modile");
        String mess = getType(modile);
        return mess;
    }

    private String getType(Modile modile) {
        ConsumInfo info=new ConsumInfo();
        Random random = new Random();
        int temp = random.nextInt(6);
        String mess = null;
        String messName = "";
        int num=0;
        switch (temp) {
            case 0:
                num=30;
                messName="通话";
                mess="<p>通话了"+num+"分钟</p>";
                modile.setRealTalkTime(modile.getRealTalkTime()+num);
                break;
            case 1:
                num=10;
                messName="通话";
                mess="<p>通话了"+num+"分钟</p>";
                modile.setRealTalkTime(modile.getRealTalkTime()+num);
                break;
            case 2:
                num=20;
                messName="短信";
                mess="<p>发送短信"+num+"条</p>";
                modile.setRealSMSCount(modile.getRealSMSCount()+num);
                break;
            case 3:
                num=10;
                messName="短信";
                mess="<p>发送短信"+num+"条</p>";
                modile.setRealSMSCount(modile.getRealSMSCount()+num);
                break;
            case 4:
                num=10;
                messName="上网";
                mess="<p>使用流量"+num+"GB</p>";
                modile.setRealFlow(modile.getRealFlow()+num);
                break;
            case 5:
                num=20;
                messName="上网";
                mess="<p>使用流量"+num+"GB</p>";
                modile.setRealFlow(modile.getRealFlow()+num);
                break;
        }
        info.setCardNumber(modile.getCardNumber());
        info.setConsumData(num+"");
        info.setType(messName);
        info.setPrice(0);
        if (messName.equals("通话")){
            if (modile.getPas().getTalkTime()>num){
                modile.getPas().setTalkTime(modile.getPas().getTalkTime()-num);
            }else {
                info.setPrice(num*1);
                if (modile.getMoney()<info.getPrice()){
                    return mess="<p style='color:red'>请及时充值在使用嗖嗖！！！</p>";
                }
                modile.setSonsumAmount(modile.getSonsumAmount()+info.getPrice());
                modile.setMoney(modile.getMoney()-info.getPrice());
            }
        }else if (messName.equals("短信")){
            if (modile.getPas().getSmsCount()>num){
                modile.getPas().setSmsCount(modile.getPas().getSmsCount()-num);
            }else{
                info.setPrice(num*1);
                if (modile.getMoney()<info.getPrice()){
                    return mess="<p style='color:red'>请及时充值在使用嗖嗖！！！</p>";
                }
                modile.setSonsumAmount(modile.getSonsumAmount()+info.getPrice());
                modile.setMoney(modile.getMoney()-info.getPrice());
            }
        }else {
            modile.getPas().setFlow(modile.getPas().getFlow()/1024);
            if (modile.getPas().getFlow()>num){
                modile.getPas().setFlow(modile.getPas().getFlow()-num);
            }else{
                info.setPrice(num*1);
                if (modile.getMoney()<info.getPrice()){
                    return mess="<p style='color:red'>请及时充值在使用嗖嗖！！！</p>";
                }
                modile.setSonsumAmount(modile.getSonsumAmount()+info.getPrice());
                modile.setMoney(modile.getMoney()-info.getPrice());
            }
        }



        Integer integer1 = consumInfoService.addConsumInfo(info);
        Integer integer2 = modileService.updModile(modile);

        if (integer1>0 && integer2>0){
            mess+="<p style='color:green'>已添加一条消费记录!!!</p>";
        }
        return mess;
    }


    //用户登录界面
    @RequestMapping("/doLogin.html")
    public String index(HttpSession session) {
        return "login";
    }

    /**
     * 用户菜单
     *
     * @param session
     * @return
     */
    @RequestMapping("/showUser.html")
    public String showUser(HttpSession session) {
        if (session.getAttribute("modile") == null) {
            return "login";
        }
        return "showUser";
    }

    @RequestMapping("/showUser")
    @ResponseBody
    public Object showUser_01(@RequestParam("name") String name,
                              HttpSession session) {

        Modile modile = (Modile) session.getAttribute("modile");
        String mess = "";
        if (name.equals("本月账单查询")) {
            mess += "<p>您的卡号：" + modile.getCardNumber() + "，当前账单：</p>";
            mess += "<p>套餐资费：" + modile.getPas().getPrice() + "元\n</p>";
            mess += "<p>合计：" + (modile.getMoney() + modile.getPas().getPrice()) + "元\n</p>";
            mess += "<p>用户余额：" + modile.getMoney() + "元</p>";
        } else if (name.equals("套餐余额查询")) {
            mess += "<p>您的卡号是：" + modile.getCardNumber() + "，套餐内剩余：</p>";
            mess += "<p>通话时长：" + modile.getPas().getTalkTime() + "分钟\n</p>";
            mess += "<p>短信条数：" + modile.getPas().getSmsCount() + "条\n</p>";
            mess += "<p>上网流量：" + ((modile.getPas().getFlow() == 1) ? modile.getPas().getFlow() : (modile.getPas().getFlow() / 1024)) + "GB</p>";
        } else if (name.equals("打印消费详单")) {
            mess += bufferedWriter(modile.getCardNumber());
        } else if (name.equals("套餐变更")) {
            mess += "<button class='myButton1 btn btn-danger form-control h5' onclick='getValue1()' value='1'>1、话痨套餐</button>\t";
            mess += "<button class='myButton2 btn btn-success form-control h5' onclick='getValue2()' value='2'>2、网虫套餐</button>\t";
            mess += "<button class='myButton3 btn btn-primary form-control h5' onclick='getValue3()' value='3'>3、超人套餐</button>";
        } else if (name.equals("办理退网")) {
            Integer integer = modileService.delModile(modile.getId());
            if (integer > 0) {
                session.removeAttribute("modile");
                mess += "<p>卡号：" + modile.getCardNumber() + "办理退网成功！</p>";
                mess += "<p>谢谢使用嗖嗖移动</p>";
            } else {
                mess += "<p>办理退网失败！</p>";
            }

        }
        return mess;
    }


    /**
     * 套餐办理
     *
     * @param paId
     * @param session
     * @return
     */
    @RequestMapping("/updPas")
    @ResponseBody
    public Object showUser_02(@RequestParam("paId") Integer paId,
                              HttpSession session) {
        Modile modile = (Modile) session.getAttribute("modile");
        String mess = "";
        Packages pas = packageService.getByPackagePaId(paId);
        if (modile.getMoney() != null && pas != null) {
            if (modile.getMoney() < pas.getPrice()) {
                mess += "<p>对不起，您的余额不足以支付新套餐本月资费，请充值后在办理更换套餐业务！</p>";
                return mess;
            } else {
                modile.setMoney(modile.getMoney() - pas.getPrice());
                Integer integer1 = modileService.updMoney(modile.getCardNumber(), modile.getMoney());
                Integer integer2 = modileService.updModilePas(paId, modile.getId());
                if (integer1 > 0 && integer2 > 0) {
                    mess += "<p style='color: green' class='h3'>更换套餐成功!</p>";
                    mess += "<p>" + pas.getName() + ":</p>";
                    mess += "<p>通话时长为" + pas.getTalkTime() + "分钟/月</p>";
                    mess += "<p>短信条数为：" + pas.getSmsCount() + "条/月</p>";
                    mess += "<p>上网流量为：" + (pas.getFlow() / 1024) + "GB/月</p>";
                    mess += "<p>套餐资费为：" + pas.getPrice() + "元/月</p>";
                } else {
                    mess += "<p style='color: green' class='h3'>更换套餐失败!</p>";
                }
            }
        }
        return mess;
    }


    //用户登录
    @RequestMapping("/doLogin")
    @ResponseBody
    public Object index(@RequestParam(value = "cardNumber", required = false) String cardNumber,
                        @RequestParam(value = "passWord", required = false) String passWord,
                        HttpSession session) {
        Modile modile = modileService.getModileByCardNumberAndPassWord(cardNumber, passWord);
        if (modile != null) {
            session.setAttribute("modile", modile);
            return modile;
        } else {
            return "erorrs";
        }

    }

    //首页
    @RequestMapping("/index.html")
    public String doLogin(HttpSession session) {
        List<Modile> lists = modileService.getModileList();
        session.setAttribute("lists", lists);
        return "showInfo";
    }

    //用户注册
    @RequestMapping("/userLogin.html")
    public String userLogin(HttpSession session) {
        List<String> numberList = getNumber();
        session.setAttribute("numberList", numberList);
        return "userLogin";
    }

    /**
     * 注册用户
     *
     * @param modile
     * @param session
     * @return
     */
    @RequestMapping("/addUserLogin.html")
    public String addUserLogin(Modile modile, HttpSession session) {
        modile.setRealSMSCount(0);
        modile.setRealTalkTime(0);
        modile.setSonsumAmount(0);
        modile.setRealFlow(0);
        Integer integer = modileService.addModile(modile);
        String mess = "";
        if (integer > 0) {
            mess = "注册成功！卡号：" + modile.getCardNumber() + " 用户名为：" + modile.getUserName() + " 当前余额为：" + modile.getMoney() + "元。";
            mess += "\n" + modile.getPas().getName() + "：通话时长为" + modile.getPas().getTalkTime() + "分钟/月" + "，短信条数为" + modile.getPas().getSmsCount() + "条/月" + "，上网流量为" + (modile.getPas().getFlow()) + "GB/月。";
        } else {
            mess = "注册失败";
        }
        session.setAttribute("mess", mess);
        return "redirect:index.html";
    }

    private List<String> getNumber() {
        List<String> list = new ArrayList<String>();
        Random random = new Random();
        List<Modile> modileList = modileService.getModileList();
        String num = "";
        boolean isExist = false;

        for (int i = 0; i < 9; i++) {
            int temp = 0;
            do {
                isExist = false;
                do {
                    temp = random.nextInt(100000000);
                } while (temp < 10000000);
                num = "139" + temp;
                for (Modile item : modileList) {
                    if (num.equals(item.getCardNumber())) {
                        System.out.println("》》》》》》》》》重复了" + num + "=" + item.getCardNumber());
                        isExist = true;
                        break;
                    }
                }
            } while (isExist == true);
            num = "139" + temp;
            list.add(num);
        }

        return list;
    }

    /**
     * 话费充值界面
     *
     * @return
     */
    @RequestMapping("/telePhone.html")
    public String telePhone(HttpSession session) {
        if (session.getAttribute("modile") == null) {
            return "login";
        }
        return "telePhone";
    }

    /**
     * 充值话费
     *
     * @param session
     * @return
     */
    @RequestMapping("/updMoney.html")
    public String updMoney(@RequestParam("cardNumber") String cardNumber,
                           @RequestParam("money") Integer money,
                           HttpSession session) {
        Modile modile = (Modile) session.getAttribute("modile");
        modile.setMoney(modile.getMoney() + money);
        Integer integer = modileService.updMoney(cardNumber, modile.getMoney());
        if (integer > 0) {
            session.setAttribute("mess", "充值成功,当前话费余额为" + modile.getMoney() + "元");
        }
        return "redirect:/index.html";
    }

    /**
     * 资费说明
     *
     * @param session
     * @return
     */
    @RequestMapping("/description.html")
    public String showDescription(HttpSession session) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("F:/Y2/MobileCardManager/src/main/java/cn/bdqn/套餐资费说明.txt"));
            List<String> list = new ArrayList<String>();
            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
            session.setAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "description";
    }

    /**
     * 打印消费账单
     */
    private String bufferedWriter(String cardNumber) {
        BufferedWriter bw = null;
        String mess = "";
        List<ConsumInfo> infoList = consumInfoService.getByConsumInfoCardNumber(cardNumber);
        if (infoList.size() <= 0) {
            mess += "<p class='h2'>对不起，不存在此卡号的消费记录，不能打印！！！</p>";
            return mess;
        }
        try {
            bw = new BufferedWriter(new FileWriter("F:/Y2/MobileCardManager/src/main/java/cn/bdqn/卡号" + cardNumber + "消费记录.txt"));
            mess += "*************" + cardNumber + "消费记录*************\n";
            mess += "序号\t\t类型\t\t消费价格\t\t数据(通话(条)/上网(MB)/短信(条))\n";
            for (int i = 0; i < infoList.size(); i++) {
                mess += "" + (i + 1) + "\t\t" + infoList.get(i).getType() + "\t\t" + infoList.get(i).getPrice() + "元\t\t\t" + infoList.get(i).getConsumData() + "\n";
            }
            bw.write(mess);
            bw.flush();
            mess = "<p class='h2'>打印成功！！！<p>";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mess;
    }

    /**
     * 退出系统
     * @param session
     * @return
     */
    @RequestMapping("/exitSystem")
    @ResponseBody
    public Object exitSystem(HttpSession session){
        session.removeAttribute("modile");
        return 1;
    }
}
