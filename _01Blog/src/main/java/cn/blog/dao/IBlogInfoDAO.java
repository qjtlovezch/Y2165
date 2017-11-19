package cn.blog.dao;

import cn.blog.entity.BlogInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Happy on 2017-07-02.
 */
public interface IBlogInfoDAO {
    //01.显示所有博客记录
    //public List<BlogInfo> getAll() throws Exception;
    //博客列表+分页
    public List<BlogInfo> getAll(int pageIndex,int pageSize) throws Exception;
    //查询总记录数
    public  int getcount() throws Exception;

    //删除
    public boolean Delblog(int blogid) throws Exception;

    //添加博客
    public  boolean addBlog(BlogInfo info) throws  Exception;

    //修改博客
    public  boolean editBlog(BlogInfo info) throws  Exception;
    //根据id查询记录
    public List<BlogInfo> getid() throws Exception;

}
