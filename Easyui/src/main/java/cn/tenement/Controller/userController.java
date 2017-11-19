package cn.tenement.Controller;

import cn.tenement.Dao.IUserInfoDao;
import cn.tenement.Dao.providerDao;
import cn.tenement.Entity.Provider;
import cn.tenement.Entity.User;
import cn.tenement.Entity.role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sunbin on 2017/9/9.
 */
@Controller
public class userController {
    @Autowired()
    providerDao pro;
    @Autowired()
    IUserInfoDao userInfoDao;
@RequestMapping("/login.do")
    public String login(String user , String pwd, HttpServletRequest request){

    User login = userInfoDao.login(user, pwd);
         if(null==login){
          request.setAttribute("login","账号密码错误");
             return "/login";
         }else {
             List<role> list= userInfoDao.rolelist();
             for (role item:list) {
                 System.out.println(item.getRoleName());
             }
             List<Provider> listpro=pro.list(0,10);
             request.getSession().setAttribute("lists",listpro);
             request.getSession().setAttribute("user",login.getUserName());
             request.getSession().setAttribute("userId",login.getId());
             request.getSession().setAttribute("userRole",login.getUserRole());
             request.getSession().setAttribute("role",list);
             return "/tree";
         }

}
    @RequestMapping("/tuichu.do")
    public String tuichu(HttpSession session){
        session.invalidate();
       return "/login";

    }
}
