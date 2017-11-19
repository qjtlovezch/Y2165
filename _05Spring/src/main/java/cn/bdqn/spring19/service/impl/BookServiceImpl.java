package cn.bdqn.spring19.service.impl;



import cn.bdqn.spring19.dao.IBookDAO;
import cn.bdqn.spring19.entity.Book;
import cn.bdqn.spring19.service.IBookService;

import java.util.List;

/**
 * Created by Happy on 2017-08-02.
 */
public class BookServiceImpl implements IBookService {

    //植入dao
    private IBookDAO dao;

    public List<Book> findAll() {
        return dao.findAll();
    }

    public IBookDAO getDao() {
        return dao;
    }

    public void setDao(IBookDAO dao) {
        this.dao = dao;
    }
}
