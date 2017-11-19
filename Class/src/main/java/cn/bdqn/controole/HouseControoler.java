package cn.bdqn.controole;


import cn.bdqn.entity.Category;
import cn.bdqn.entity.Houseinfo;
import cn.bdqn.entity.Housetype;

import cn.bdqn.service.IHouseService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class HouseControoler {
    @Resource(name = "houseservice")
    IHouseService service;

    @RequestMapping("/dolist")
    public String dolist(HttpSession session) {
        List<Houseinfo> houselist = service.houselist();
        session.setAttribute("houselist",houselist);
        return "/wenti.jsp";
    }

    @RequestMapping("/typelist")
    public String typelist(HttpSession session){
        List<Housetype> typelist = service.typelist();
        session.setAttribute("typelist",typelist);
        return "/add.jsp";
    }

    @RequestMapping("/add")
    public String add(Houseinfo info){
         info.setTypeid(info.getTypeid());
         info.setHousedesc(info.getHousedesc());
        info.setPublishdate(new Date());
        info.setMonthlyrent(info.getMonthlyrent());
        int inser = service.inser(info);
        if (inser>0){
            return "redirect:/dolist";
        }
        return "/add.jsp";
    }

    @RequestMapping("/info/{id}")
    public String info(@PathVariable int id, HttpSession session){
        List<Houseinfo> infolist = service.infolist(id);
        session.setAttribute("houselist",infolist);
        return "/jiansuo.jsp";
    }
    @RequestMapping("/dolists")
    public String dolists(HttpSession session, String housedesc) {
        List<Houseinfo> houselist = service.infolists(housedesc);
        session.setAttribute("houselist",houselist);
        session.setAttribute("housedesc",housedesc);
        return "/wenti.jsp";
    }

    @ResponseBody
    @RequestMapping("/one")
    public Object one(){
        List<Category> list=service.allCateType();
        return list;
    }
}
