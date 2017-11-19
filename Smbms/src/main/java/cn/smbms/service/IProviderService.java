package cn.smbms.service;

import cn.smbms.entity.Provider;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/25.
 */
public interface IProviderService {
    //供应商列表
    public List<Provider> prolist();

    //删除
    public int prodel(int id);

    //根据id查询
    public List<Provider> idlist(int id);

    //模糊查询
    public List<Provider> prolike(Provider provider);

    //添加
    public int proadd(Provider provider);
    //修改
    public int update(Provider id);
    //根据id查询，进行修改传值
    public Provider  Pupdate(int id);
}
