package cn.bdqn.servlet;

import cn.bdqn.entity.User;
import cn.bdqn.service.IUserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by QiuShao on 2017/8/7.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("textml;charset=UTF-8");
        response.setHeader("content-type", "textml;charset=UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            if ("login".equals(action)) {
                int upwd = Integer.parseInt(request.getParameter("upwd"));
                String uname = request.getParameter("uname");
                User info = new User();
                info.setUname(uname);
                info.setUpwd(upwd);
                WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
                IUserService service = (IUserService) ctx.getBean("userService");
                int count = service.isLogin(info);
                if (count > 0) {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
