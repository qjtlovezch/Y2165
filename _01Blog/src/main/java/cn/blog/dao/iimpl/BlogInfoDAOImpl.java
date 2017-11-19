package cn.blog.dao.iimpl;

import cn.blog.dao.BaseDao;
import cn.blog.dao.IBlogInfoDAO;
import cn.blog.entity.BlogInfo;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Happy on 2017-07-02.
 */
public class BlogInfoDAOImpl extends BaseDao implements IBlogInfoDAO {

   /* public void testall() throws Exception {
        List<BlogInfo> list= getAll();
        for (BlogInfo info:list) {
            System.out.println(info.getBlogAuthor());
        }
    }*/

    @Test
    public void all() throws Exception {
        List<BlogInfo> list = getAll(1,3);
        for (BlogInfo item: list) {
            System.out.println(item.getBlogAuthor());
        }
    }
    public List<BlogInfo> getAll(int pageIndex, int pageSize) throws Exception {
        List<BlogInfo> list=new ArrayList<BlogInfo>();
        String sql="select * from bloginfo limit ?,?";
        Object []obj={(pageIndex-1)*pageSize,pageSize};
        rs = executeQuery(sql, obj);
        if (rs!=null){
            while(rs.next()){
                BlogInfo info=new BlogInfo();
                info.setBlogId(rs.getInt("BlogId"));
                info.setBlogAuthor(rs.getString("BlogAuthor"));
                info.setBlogAddress(rs.getString("BlogAddress"));
                info.setBlogDel(rs.getBoolean("BlogDel"));
                list.add(info);
            }
        }
        return list;
    }
    @Test
    public void count() throws Exception {
        int getcount = getcount();
        System.out.println(getcount);
    }
    public int getcount() throws Exception {
        int result=0;
        String sql="select count(*) as num from bloginfo";
        rs = executeQuery(sql);
        if (rs!=null){
            if (rs.next()){
                result=rs.getInt("num");
            }
        }
        return result;
    }
    @Test
    public void de() throws Exception {
        boolean flag = Delblog(4);
        System.out.println(flag);
    }
    public boolean Delblog(int blogid) throws Exception {
        boolean flag=false;
        String sql="DELETE FROM bloginfo WHERE blogid="+blogid;
        int count = executeUpdate(sql);
        if(count>0){
            flag=true;
        }
        return flag;
    }

    public boolean addBlog(BlogInfo info) throws Exception {
        boolean flag=false;
        String  sql="insert into bloginfo(blogAuthor,blogAddress,blogDel) values(?,?,0)";
        Object[] para={info.getBlogAuthor(),info.getBlogAddress()};
        int count = executeUpdate(sql, para);
        if (count>0){
            flag=true;
        }
        return flag;
    }

    public boolean editBlog(BlogInfo info) throws Exception {
        boolean flag=false;
        String sql="update blogInfo set blogAuthor=?,blogAddress=? where blogId=?";
        Object[] paras={info.getBlogAuthor(),info.getBlogAddress(),info.getBlogId()};
        int count = executeUpdate(sql, paras);
        if (count>0){
            flag=true;
        }
        return flag;

    }

    public List<BlogInfo> getid() throws Exception {
        List<BlogInfo> list=new ArrayList<BlogInfo>();
        String sql="select * from bloginfo where blogId=?";
        ResultSet rs = executeQuery(sql);
        while (rs.next()){
            BlogInfo info=new BlogInfo();
            info.setBlogId(rs.getInt("blogId"));
            info.setBlogAuthor(rs.getString("blogAuthor"));
            info.setBlogAddress(rs.getString("blogAddress"));
            info.setBlogDel(rs.getBoolean("blogDel"));
            list.add(info);
        }
        return list;
    }
 /* public List<BlogInfo> getAll() throws Exception {
        List<BlogInfo> list=new ArrayList<BlogInfo>();
        String sql="select * from bloginfo where blogDel=0";
        ResultSet rs = executeQuery(sql);
        while(rs.next()){
            BlogInfo info=new BlogInfo();
            info.setBlogId(rs.getInt("blogId"));
            info.setBlogAuthor(rs.getString("blogAuthor"));
            info.setBlogAddress(rs.getString("blogAddress"));
            info.setBlogDel(rs.getBoolean("blogDel"));

            list.add(info);
        }
        return list;
    }*/

}
