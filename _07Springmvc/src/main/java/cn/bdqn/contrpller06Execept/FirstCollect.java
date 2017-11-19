package cn.bdqn.contrpller06Execept;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by QiuShao on 2017/8/20.
 */
@Controller
public class FirstCollect {
    //异常
    @RequestMapping("/first")
    public String one(){
        int i=5/0;
        return "/WEB-INF/delete.jsp";
    }
}
