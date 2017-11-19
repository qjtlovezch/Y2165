package cn.bdqn.spring21.servlet;

import cn.bdqn.spring21.entity.Book;
import cn.bdqn.spring21.service.IBookSrvice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("textml;charset=UTF-8");
        response.setHeader("content-type", "textml;charset=UTF-8");
        String action=request.getParameter("action");
        if (action!=null){
            if ("add".equals(action)){
                String bookname=request.getParameter("bookName");
                int bookprice=Integer.parseInt(request.getParameter("bookPrice"));
                Book b=new Book();
                b.setBookName(bookname);
                b.setBookPrice(bookprice);

                WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
                System.out.println(ctx);
                /*ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextspring19.xml");*/
                IBookSrvice service = (IBookSrvice) ctx.getBean("bookService");
                int i = service.addbook(b);
                if (i>0){
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }else {
                    request.getRequestDispatcher("/addBook.jsp").forward(request,response);
                }

            }
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
