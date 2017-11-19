package cn.bdqn.dao;

import cn.bdqn.entity.Student;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public interface IStudentDAO {
    //查询所有学生
    public List<Student> getAll();
}
