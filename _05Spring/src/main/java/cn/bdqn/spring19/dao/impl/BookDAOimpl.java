package cn.bdqn.spring19.dao.impl;

import cn.bdqn.spring19.dao.IBookDAO;
import cn.bdqn.spring19.entity.Book;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/2.
 */
public class BookDAOimpl extends JdbcDaoSupport implements IBookDAO{
    public List<Book> findAll() {
        String sql="select * from book";
        List<Book> list=this.getJdbcTemplate().query(sql, new RowMapper<Book>() {

            public Book mapRow(ResultSet rs, int i) throws SQLException {
                Book book=new Book();
                book.setBookid(rs.getInt("Id"));
                book.setBookname(rs.getString("Name"));
                book.setBookprice(rs.getInt("Price"));
                return book;
            }
        });

        return list;
    }
}
