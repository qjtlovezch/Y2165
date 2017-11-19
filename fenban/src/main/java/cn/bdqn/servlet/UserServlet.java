package cn.bdqn.servlet;

import cn.bdqn.entity.ClassRoom;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import cn.bdqn.entity.studentattendance;
import cn.bdqn.service.IUserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

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
 * Created by QiuShao on 2017/8/11.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("textml;charset=UTF-8");
        response.setHeader("content-type", "textml;charset=UTF-8");

        String action = request.getParameter("action");
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        IUserService service = (IUserService) ctx.getBean("userService");
        if (action != null) {
            if ("login".equals(action)) {
                String upwd = request.getParameter("upwd");
                String uname = request.getParameter("uname");
                User info = new User();
               info.setLogincode(uname);
               info.setLoginpassword(upwd);
                int count = service.isLogin(info);
                if (count > 0) {
                    request.getRequestDispatcher("/UserServlet?action=class").forward(request, response);
                } else {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }

            }else if ("class".equals(action)){

                List<ClassRoom> list=service.getAllclass();
                request.setAttribute("list",list);
                request.getRequestDispatcher("/class.jsp").forward(request,response);

            }else if("student".equals(action)){

                int id=Integer.parseInt(request.getParameter("id"));
                List<Student> list=service.getallstudent(id);
                request.setAttribute("list",list);
                request.getSession().setAttribute("id",id);
                request.getRequestDispatcher("/kaoqin.jsp").forward(request,response);

            }else if("in".equals(action)){
                Integer id = (Integer) request.getSession().getAttribute("id");
                List<Student> list=service.getallstudent(id);
                for (Student stu : list) {
                    Integer studentid =stu.getStudentid();
                    String parameter = request.getParameter(String.valueOf(studentid));
                    studentattendance att = new studentattendance();
                    att.setAttendanceid(Integer.parseInt(parameter));
                    att.setAttendancetime(new Date());
                    att.setStudentid(stu.getStudentid());
                    service.insert(att);
                }
                request.getRequestDispatcher("/UserServlet?action=class").forward(request,response);
            }else if ("data".equals(action)){
                String datetime = request.getParameter("time");
                SimpleDateFormat froFormat=new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date time = froFormat.parse(datetime);
                    System.out.println(time);
                    List<studentattendance> list = service.getAllByTime(time);
                    request.setAttribute("list",list);
                    request.setAttribute("datetimes", datetime);
                    request.getRequestDispatcher("/shijian.jsp").forward(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
