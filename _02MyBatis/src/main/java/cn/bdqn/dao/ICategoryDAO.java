package cn.bdqn.dao;

import cn.bdqn.entity.Category;

import java.util.List;

/**
 * Created by QiuShao on 2017/7/14.
 */
public interface ICategoryDAO {

    public List<Category> getabypid(int pid);
}
