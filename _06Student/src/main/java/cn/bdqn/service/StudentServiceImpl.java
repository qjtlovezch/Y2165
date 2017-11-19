package cn.bdqn.service;

import cn.bdqn.dao.IStudentDAO;
import cn.bdqn.entity.Student;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class StudentServiceImpl implements IStudentService {
    IStudentDAO dao;

    public IStudentDAO getDao() {
        return dao;
    }

    public void setDao(IStudentDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Student> getAll() {
        return dao.getAll();
    }
}
