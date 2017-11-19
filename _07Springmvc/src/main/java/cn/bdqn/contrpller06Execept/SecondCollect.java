package cn.bdqn.contrpller06Execept;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by QiuShao on 2017/8/20.
 */
@Controller
public class SecondCollect {
    //异常
    @RequestMapping("/two")
    public String one(UserInfo info) throws NameException {
      if(!info.getName().equals("admin")){
          throw new NameException("用户名异常");
      }
      if (info.getAge()>50){
          throw new NameException("年龄异常");
      }
        return "/WEB-INF/delete.jsp";
    }
}
