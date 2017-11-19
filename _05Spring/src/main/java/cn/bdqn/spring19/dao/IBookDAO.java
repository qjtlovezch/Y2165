package cn.bdqn.spring19.dao;

import cn.bdqn.spring19.entity.Book;
import java.util.List;

/**
 * Created by Happy on 2017-08-02.
 */
public interface IBookDAO {
    //查询素有图书
    public List<Book> findAll();
}
