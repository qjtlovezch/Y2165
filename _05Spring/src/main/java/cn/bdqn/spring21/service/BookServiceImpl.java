package cn.bdqn.spring21.service;

import cn.bdqn.spring21.dao.IBookDAO;
import cn.bdqn.spring21.entity.Book;

/**
 * Created by QiuShao on 2017/8/6.
 */
public class BookServiceImpl implements IBookSrvice {
    IBookDAO dao;

    public IBookDAO getDao() {
        return dao;
    }

    public void setDao(IBookDAO dao) {
        this.dao = dao;
    }

    public int addbook(Book book) {

        return dao.addbook(book);
    }
}
