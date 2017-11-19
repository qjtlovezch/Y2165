package cn.blog.servlet;

import cn.blog.dao.IBlogInfoDAO;
import cn.blog.dao.iimpl.BlogInfoDAOImpl;
import cn.blog.entity.BlogInfo;
import cn.blog.util.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Happy on 2017-07-02.
 */
public class BlogInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("texthtml;charset=UTF-8");
        response.setHeader("content-type", "texthtml;charset=UTF-8");

        request.setCharacterEncoding("utf-8");
        //1.实例化博客dao
        IBlogInfoDAO dao=new BlogInfoDAOImpl();
        //2.获取泛型
        //删除
        String action=request.getParameter("action");

        if (action!=null){
            if ("update".equals(action)){
                BlogInfo blogInfo=new BlogInfo();

                String blogAuthor=request.getParameter("blogAuthor");
                String blogAddress=request.getParameter("blogAddress");
                int blogId=Integer.parseInt(request.getParameter("blogId"));
                blogInfo.setBlogAuthor(blogAuthor);
                blogInfo.setBlogAddress(blogAddress);
                blogInfo.setBlogId(blogId);
                try {

                    boolean flag = dao.editBlog(blogInfo);
                    if (flag){
                        request.getRequestDispatcher("/BlogInfoServlet?action=list").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if("add".equals(action)){
                BlogInfo blogInfo=new BlogInfo();
                String blogAuthor=request.getParameter("blogAuthor");
                String blogAddress=request.getParameter("blogAddress");
                blogInfo.setBlogAuthor(blogAuthor);
                blogInfo.setBlogAddress(blogAddress);
                try {
                    boolean flag = dao.addBlog(blogInfo);
                    if (flag){
                        request.getRequestDispatcher("/BlogHtTemplate-master/html/blog/main.jsp").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else if("del".equals(action)){
                String blogid=request.getParameter("blogId");

                try {
                    boolean flag = dao.Delblog(Integer.parseInt(blogid));
                    if (flag){
                        //response.sendRedirect("BlogInfoServlet");
                        request.getRequestDispatcher("/BlogInfoServlet?action=list").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if("list".equals(action)){
                //列表+分页
                Page page=new Page();
                //每页显示的记录数
                int pageSize=9;
                page.setPageSize(pageSize);
  ;
                //当前页数
                int MyIndex=1;
                String pageIndex=request.getParameter("pageIndex");

                if (pageIndex!=null && (!pageIndex.equals(""))){
                    MyIndex=Integer.parseInt(pageIndex);
                }

                page.setPageIndex(MyIndex);

                //计算总页数
                int totapages=0;
                try {
                    int count = dao.getcount();
                    if (count%pageSize==0){
                        totapages=count/pageSize;
                    }else{
                        totapages=count/pageSize+1;
                    }
                    page.setTotapages(totapages);


                    if (MyIndex>page.getTotapages()){
                        MyIndex=page.getTotapages();
                    }
                    if(MyIndex<1){
                        MyIndex=1;
                    }
                page.setPageIndex(MyIndex);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //装载集合
                try {
                    List<BlogInfo> list = dao.getAll(page.getPageIndex(),pageSize);
                    page.setBloglist(list);
                    request.setAttribute("page",page);

                    request.getRequestDispatcher("BlogHtTemplate-master/html/blog/bloglist.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else{
            //列表+分页
            Page page=new Page();
            //每页显示的记录数
            int pageSize=9;
            page.setPageSize(pageSize);

            //当前页数
            int MyIndex=1;
            String pageIndex=request.getParameter("pageIndex");

            if (pageIndex!=null){
                MyIndex=Integer.parseInt(pageIndex);
            }else{
                MyIndex=1;
            }

            page.setPageIndex(MyIndex);

            //计算总页数
            int totapages=0;
            try {
                int count = dao.getcount();
                if (count%pageSize==0){
                    totapages=count/pageSize;
                }else{
                    totapages=count/pageSize+1;
                }
                page.setTotapages(totapages);
                if (MyIndex>page.getTotapages()){
                    MyIndex=page.getTotapages();

                }
                if(MyIndex<1){
                    MyIndex=1;
                }
                page.setPageIndex(MyIndex);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //装载集合
            try {
                List<BlogInfo> list = dao.getAll(page.getPageIndex(),pageSize);
                page.setBloglist(list);
                request.setAttribute("page",page);

                request.getRequestDispatcher("BlogHtTemplate-master/html/blog/bloglist.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
