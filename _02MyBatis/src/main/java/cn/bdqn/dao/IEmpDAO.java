package cn.bdqn.dao;

import cn.bdqn.entity.Emp;

/**
 * Created by QiuShao on 2017/7/14.
 */
public interface IEmpDAO {
   /* 多对一 单sql*/
    public Emp getempon(int empNo);

    /*多对一 多sql*/
    public Emp getemp(int empNo);

}
