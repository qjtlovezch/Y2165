package cn.bdqn.dao;

import cn.bdqn.entity.Dept;

import java.util.List;
import java.util.Map;

/**
 * Created by 邱少 on 2017/7/6.
 */
public interface IDeptDao {
    //查询所有
    public List<Dept> getAll();
    //根据id查询
    public Dept getid(int blogId);
    //添加
    public int insert(Dept info);
    //修改
    public int upd(Dept info);
    //删除
    public int del(int stuid);
    //模糊查询
    public List<Dept> findAll(Dept info);
    //多添件查询
    public List<Dept> find(Map<String ,Object> map);
    //多添件查询索引
    public List<Dept> findsuo(String blogAuthor,int blogId);
    //智能标签if
    public List<Dept> findByIf(Dept dept);
    //智能标签choose
    public List<Dept> findchoose(Dept dept);
    //智能标签foreach array
    public List<Dept> findforeacharray(int[] dept);
    //智能标签foreach list<Integer>
    public List<Dept> findlist(List<Integer> list);
    //智能标签foreach array<Dept>
    public List<Dept> findDept(List<Dept> list);



}
