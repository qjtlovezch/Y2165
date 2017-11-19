package cn.blog.dao;

import cn.blog.entity.home;

import java.util.List;

/**
 * Created by QiuShao on 2017/7/7.
 */
public interface IhomeDAO {
    public  boolean addhome(home home) throws  Exception;

    public List<home> findAll() throws  Exception;
}
