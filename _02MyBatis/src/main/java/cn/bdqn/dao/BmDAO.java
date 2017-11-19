package cn.bdqn.dao;

import cn.bdqn.entity.deptt;

/**
 * Created by QiuShao on 2017/7/13.
 */
public interface BmDAO {
    //根据部门编号，检索部门名称以及该部门下所有员工的信息 单sql
    public deptt getEmpsByDeptNo(int deptNo);
    //根据部门编号，检索部门名称以及该部门下所有员工的信息 多SQL
    public deptt getNo(int deptNo);
}
