package cn.bdqn.contrpller02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by QiuShao on 2017/8/18.
 */
@Controller
@RequestMapping("hh")
public class Mycont {
    @RequestMapping(value = "/{uname}/{uage}/one",method = {RequestMethod.POST,RequestMethod.GET})
    public String doone(@PathVariable() String uname,@PathVariable() String uage){
        System.out.println(uname);
        System.out.println(uage);
        return "/WEB-INF/insert.jsp";
    }
    @RequestMapping("/two")
    public String dotwo(){
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/*three")
    public String dothree(){
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/four*")
    public String dofour(){
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/**/five")
    public String dofive(){
        return "/WEB-INF/delete.jsp";
    }
    @RequestMapping("/*/six")
    public String dosix(){
        return "/WEB-INF/delete.jsp";
    }


}
