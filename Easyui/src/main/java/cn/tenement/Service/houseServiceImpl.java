package cn.tenement.Service;

import cn.tenement.Dao.houseDao;
import cn.tenement.Entity.category;
import cn.tenement.Entity.houseinfo;
import cn.tenement.Entity.two;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunbin on 2017/8/30.
 */
@Service("houseService")
public class houseServiceImpl implements IhouseService {
    @Resource
    houseDao house;
    public List<houseinfo> list() {
        return house.list();
    }

    public List<houseinfo> lists(String typename) {
        return house.lists(typename);
    }

    public int insert(houseinfo houses) {
        return house.insert(houses);
    }

    public List<houseinfo> select(int houseid) {
        return house.select(houseid);
    }

    public List<category> one(int id) {
        return house.one(id);
    }

    public List<category> two(int id) {
        return house.two(id);
    }


}
