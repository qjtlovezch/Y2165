package com.bdqn.service;

import com.bdqn.dao.ProviderDao;
import com.bdqn.pojo.Provider;
import com.bdqn.service.ProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by java on 2017-9-7.
 */
@Service(value = "providerService")
public class ProviderServiceImpl implements ProviderService {
      //植入Dao接口
    @Resource
    ProviderDao  pro;


    public List<Provider> getPro() {   //列表及分页
        return pro.getPro();
    }

    public Provider Pid(int id) {   //根据id查看
        return pro.Pid(id);
    }

    public Provider Pupdate(int id) {  //根据id查看，进行修改传值
        return pro.Pupdate(id);
    }

    public int update(Provider id) {   //修改
        return pro.update(id);
    }

    public int delete(int id) {   //删除
        return pro.delete(id);
    }

    public int insert(Provider prov) {  //添加
        return pro.insert(prov);
    }

    public List<Provider> Mtell(String proname) {   //模糊查询
        return pro.Mtell(proname);
    }
}
