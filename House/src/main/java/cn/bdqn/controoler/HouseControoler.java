package cn.bdqn.controoler;

import cn.bdqn.entity.Houseinfo;
import cn.bdqn.entity.Housetype;
import cn.bdqn.service.IHouseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class HouseControoler {
    @Resource(name = "houseservice")
    IHouseService service;

    @RequestMapping("/dolist")
    public String dolist(HttpSession session){
        List<Houseinfo> houselist = service.houselist();
        session.setAttribute("houselist",houselist);
        return "/xinxi.jsp";
    }
    @RequestMapping("/type")
    public String typelist(HttpSession session){
        List<Housetype> list=service.getall();
        session.setAttribute("list",list);
        return "/xinxi.jsp";
    }
    @RequestMapping("/add")
    public String add(Houseinfo info){
        info.setPublishdate(new Date());
        int addhouse = service.addhouse(info);
        if (addhouse>0){
            return "/dolist";
        }else {
            return "/add";
        }
    }
}
