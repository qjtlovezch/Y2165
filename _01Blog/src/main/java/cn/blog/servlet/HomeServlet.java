package cn.blog.servlet;

import cn.blog.dao.IhomeDAO;
import cn.blog.dao.iimpl.HomeDAOImpl;
import cn.blog.entity.home;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by QiuShao on 2017/7/7.
 */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("texthtml;charset=UTF-8");
        response.setHeader("content-type", "texthtml;charset=UTF-8");
        IhomeDAO dao=new HomeDAOImpl();
        String action=request.getParameter("action");
        if (action.equals("add")){

            String homeGrade=request.getParameter("homeGrade");
            String homeTeacher=request.getParameter("homeTeacher");
            String homeChapter=request.getParameter("homeChapter");
            String homeContent=request.getParameter("homeContent");
          // String homeTime=request.getParameter("homeTime");
            /*SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");*/
            /* Date timeList=sdf.parse(homeTime);*/
            home home=new home();
            home.setHomeGrade(homeGrade);
            home.setHomeTeacher(homeTeacher);
            home.setHomeChapter(homeChapter);
            home.setHomeContent(homeContent);
            home.setHomeTime(new Date());
            try {
                boolean flag = dao.addhome(home);
                if (flag){
                    request.getRequestDispatcher("/BlogHtTemplate-master/html/blog/main.jsp").forward(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(action.equals("list")){
            try {
                List<home> list = dao.findAll();
                request.setAttribute("list",list);
                request.getRequestDispatcher("/BlogHtTemplate-master/html/teacher/homelist.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
