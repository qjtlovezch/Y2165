package cn.bdqn.service;

import cn.bdqn.entity.Student;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public interface IStudentService {
    //查询所有学生
    public List<Student> getAll();

}
