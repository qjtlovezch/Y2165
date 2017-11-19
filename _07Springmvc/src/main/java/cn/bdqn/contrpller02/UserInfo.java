package cn.bdqn.contrpller02;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/18.
 */
public class UserInfo {
    public  String uname;
    private Book book;
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
