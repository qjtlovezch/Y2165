package com.bdqn.service;

import com.bdqn.pojo.Provider;

import java.util.List;

/**
 * Created by java on 2017-9-7.
 */
public interface ProviderService {
    public List<Provider> getPro();  //列表及分页
    public Provider  Pid(int id);  //根据id查看
    public Provider  Pupdate(int id); //根据id查询，进行修改传值
    public int update(Provider id);//修改
    public int delete(int id);  //删除
    public int insert(Provider prov);  //添加
    public List<Provider> Mtell(String proname); //模糊查询
}
