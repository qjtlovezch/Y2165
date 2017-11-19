package cn.bdqn.service;

import cn.bdqn.dao.IUserDAO;
import cn.bdqn.entity.ClassRoom;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import cn.bdqn.entity.studentattendance;

import java.util.Date;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class UserServiceImpl implements IUserService{

    private IUserDAO dao;

    public IUserDAO getDao() {
        return dao;
    }

    public void setDao(IUserDAO dao) {
        this.dao = dao;
    }

    public int isLogin(User info) {
        return dao.isLogin(info);
    }

    public List<ClassRoom> getAllclass() {
        return dao.getAllclass();
    }

    public List<Student> getallstudent(int id) {
        return dao.getallstudent(id);
    }

    public int insert(studentattendance stu) {
        return dao.insert(stu);
    }

    public List<studentattendance> getAllByTime(Date time) {
        return dao.getAllByTime(time);
    }


}
