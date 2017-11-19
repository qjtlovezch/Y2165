package cn.blog.servlet;


import cn.blog.dao.iimpl.UserInfoDAOImpl;
import cn.blog.dao.iimpl.VisitDAOImpl;
import cn.blog.entity.UserInfo;
import cn.blog.entity.Visit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;


/**
 * Created by Happy on 2017-06-30.
 */
public class UserInfoServlet extends HttpServlet {

    protected String getip(HttpServletRequest request){

        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        UserInfoDAOImpl dao = new UserInfoDAOImpl();
        VisitDAOImpl logdao = new VisitDAOImpl();
    ;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("texthtml;charset=UTF-8");
        response.setHeader("content-type", "texthtml;charset=UTF-8");
        if (request.getParameter("userName") != null) {



            //String userName=request.getParameter("userName");
           String userName=new String(request.getParameter("userName").getBytes("iso-8859-1"),"utf-8");

            //String userCode = request.getParameter("userCode");
            String userPwd = request.getParameter("userPwd");
            System.out.println(userName);
            System.out.println(userPwd);

            UserInfo info = new UserInfo();
            info.setUserName(userName);
           // info.setUserCode(Integer.parseInt(userCode));
            info.setUserPwd(userPwd);

            boolean flag = false;
            try {
                flag = dao.isLogin(info);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flag) {
                //记录session
                String ipAddress = getip(request);
                if(ipAddress.equals("0:0:0:0:0:0:0:1"))
                {
                    InetAddress address=InetAddress.getLocalHost();
                    String hostAddress = address.getHostAddress();
                    ipAddress=hostAddress;
                }
                request.getSession().setAttribute("ipAddress",ipAddress);
               // request.setAttribute("ipAddress",ipAddress);
               /* String add = getIPAddress(request);*/
                Visit vs = new Visit();
                vs.setIpAddress(ipAddress);
                vs.setVisitTime(new Date());
                try {
                    logdao.addlog(vs);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //记录session
                request.getSession().setAttribute("userName",userName);
                request.setAttribute("loginsuccess","true");
                request.getRequestDispatcher("/BlogHtTemplate-master/html/blog/main.jsp").forward(request, response);

            } else {

                response.sendRedirect("/BlogHtTemplate-master/html/index.html");
            }
        }
        if ("".equals(request.getParameter("userName")) || "".equals(request.getParameter("userPwd"))) {
            request.setAttribute("longinfailure","true");
            request.getRequestDispatcher("/BlogHtTemplate-master/html/blog/main.jsp").forward(request, response);
            return;
        }
        request.setCharacterEncoding("utf-8");
        if (request.getSession().getAttribute("userName")!=null){
            request.setCharacterEncoding("utf-8");
            request.getSession().removeAttribute("userName");
            response.sendRedirect("/BlogHtTemplate-master/html/blog/main.jsp");
        return;
        }
    }

    //  dao.isLogin();
    //跳转
   /* public String getIPAddress(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }*/


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
