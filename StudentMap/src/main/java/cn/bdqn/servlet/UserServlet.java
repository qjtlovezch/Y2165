package cn.bdqn.servlet;

import cn.bdqn.entity.ClassRoom;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import cn.bdqn.service.IUserService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
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
                int upwd = Integer.parseInt(request.getParameter("upwd"));
                System.out.println(upwd);
                String uname = request.getParameter("uname");
                System.out.println(uname);
                User info = new User();
                info.setUname(uname);
                info.setUpwd(upwd);


                int count = service.isLogin(info);
                if (count > 0) {
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
            }else if ("list".equals(action)){
                List<Student> list=service.getAll();
                request.setAttribute("list",list);
                request.getRequestDispatcher("/Score.jsp").forward(request, response);
            }else if("class".equals(action)){
                List<ClassRoom> list=service.getAllclass();
                request.setAttribute("list",list);
                request.getRequestDispatcher("/class.jsp").forward(request, response);
            }else if("addclass".equals(action)){
                int cid=Integer.parseInt(request.getParameter("cid"));
                String cname=request.getParameter("cname");
                ClassRoom cr=new ClassRoom();
                cr.setCid(cid);
                cr.setCname(cname);
                int count=service.addclass(cr);
                if(count>0){
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }else{
                    request.getRequestDispatcher("/addclass.jsp").forward(request, response);
                }

            }else if("updatstudent".equals(action)){
                int sid=Integer.parseInt(request.getParameter("sid"));
                System.out.println(sid);
                String name=request.getParameter("sname");
                int score=Integer.parseInt(request.getParameter("score"));
                Student student=new Student();
                student.setSid(sid);
                student.setSname(name);
                student.setScore(score);
                int count = service.updateScore(student);
                if (count>0){
                    request.getRequestDispatcher("/UserServlet?action=list").forward(request,response);
                }else{
                    request.getRequestDispatcher("/updatestudent.jsp").forward(request,response);
                }
            }else if ("setstu".equals(action)) {

                int id = Integer.parseInt(request.getParameter("idss"));
                Student student = service.setStu(id);
                request.setAttribute("score", student);
                request.getRequestDispatcher("/updatestudent.jsp").forward(request, response);
            }
        else if("deletestudent".equals(action)){
            int id=Integer.parseInt(request.getParameter("ids"));
            int count = service.delScore(id);
            if (count>0){
                request.getRequestDispatcher("/UserServlet?action=list").forward(request,response);
            }else{
                request.getRequestDispatcher("/Score.jsp").forward(request,response);
            }
        }}
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
