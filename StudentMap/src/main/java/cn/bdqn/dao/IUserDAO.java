package cn.bdqn.dao;

import cn.bdqn.entity.ClassRoom;
import cn.bdqn.entity.Student;
import cn.bdqn.entity.User;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public interface IUserDAO {
    //登录
    public int isLogin(User info);
    //查询所有学生
    public List<Student> getAll();
    //查询所有班级
    public List<ClassRoom> getAllclass();
    //添加班级
    public int addclass(ClassRoom sclass);
    //修改成绩
    public int updateScore(Student id);
    //删除成绩
    public int delScore(int id);

    public  Student setStu(int id);

}
