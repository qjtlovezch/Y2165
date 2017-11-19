package cn.bdqn.service;

import cn.bdqn.entity.ClassRoom;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;
import cn.bdqn.entity.studentattendance;

import java.util.Date;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public interface IUserService {
    //登录
    public int isLogin(User info);
    //查询所有班级
    public List<ClassRoom> getAllclass();
    //查询学生
    public List<Student> getallstudent(int id);

    public int insert(studentattendance stu);
    //根据时间查询
    public List<studentattendance> getAllByTime(Date time);
}
