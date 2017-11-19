package cn.bdqn.contrpller02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by QiuShao on 2017/8/18.
 */
@Controller
public class Argument {
    @RequestMapping("/login")
    public String login(String uname){
        System.out.println(uname);
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/login2")
    public String login2(UserInfo info){
        System.out.println(info.getUname());
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/rightA")
    public String login3(String uname2){
        System.out.println(uname2);
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/Area")
    public String login4(UserInfo info){
        System.out.println(info.getUname()+"\t"+info.getBook().getBookname());

       /* System.out.println(info.getUname()+"\t"+info.getBooks().get(0).getBookname());*/
        return "/WEB-INF/delete.jsp";
    }
}
