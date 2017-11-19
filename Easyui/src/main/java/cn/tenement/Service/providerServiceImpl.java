package cn.tenement.Service;

import cn.tenement.Dao.providerDao;
import cn.tenement.Entity.Provider;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunbin on 2017/9/6.
 */
@Service("provider")
public class providerServiceImpl  implements IproviderService{
    @Resource
    providerDao pro;

    public List<Provider> list(int pageIndex, int pageSize) {
        System.out.println(pageIndex+"----"+pageSize);
        return pro.list(pageIndex,pageSize);
    }

    public int count(@Param("proName") String proName) {
        return pro.count(proName);
    }

    public int inserts(Provider provider) {
        return pro.inserts(provider);
    }

    public Provider provider(int id) {
        return pro.provider(id);
    }

    public int update(Provider provider) {
        return pro.update(provider);
    }

    public int delect(int id) {
        return pro.delect(id);
    }

    public List<Provider> lists(int pageIndex, int pageSize, @Param("proName") String proName) {
        return pro.lists(pageIndex,pageSize,proName);
    }
}
