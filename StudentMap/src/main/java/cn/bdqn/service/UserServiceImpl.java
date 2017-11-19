package cn.bdqn.service;

import cn.bdqn.dao.IUserDAO;
import cn.bdqn.entity.ClassRoom;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;

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

    public List<Student> getAll() {
        return dao.getAll();
    }

    public List<ClassRoom> getAllclass() {
        return dao.getAllclass();
    }

    public int addclass(ClassRoom sclass) {
        return dao.addclass(sclass);
    }

    public int updateScore(Student id) {
        return dao.updateScore(id);
    }

    public int delScore(int id) {
        return dao.delScore(id);
    }

    public Student setStu(int id) {
        return dao.setStu(id);
    }
}
