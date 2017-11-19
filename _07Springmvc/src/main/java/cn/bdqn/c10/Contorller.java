package cn.bdqn.c10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 刘振宇 on 2017/9/3.
 */
@Controller
public class Contorller {
    @RequestMapping("/first")
    public String dofirst(){
        System.out.println("dofirst");
        return "/index.jsp";
    }
}
