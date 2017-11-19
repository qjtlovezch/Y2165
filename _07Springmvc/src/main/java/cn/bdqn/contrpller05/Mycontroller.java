package cn.bdqn.contrpller05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 刘振宇 on 2017/8/20.
 */
@Controller
public class Mycontroller {
    //转发
    @RequestMapping("/adduser")
    public String add(HttpServletRequest request){
        request.setAttribute("happy","aa");
        return "/listuser";
    }

    @RequestMapping("/listuser")
    public String list(){
        return "/list.jsp";
    }

    //重定向
    @RequestMapping("/adduser2")
    public String add2(HttpServletRequest request){
        request.setAttribute("happy","aaa");
        return "redirect:/listuser";
    }

    @RequestMapping("/listuser2")
    public String list2(){
        return "redirect:/list.jsp";
    }

}
