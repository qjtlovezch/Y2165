package cn.tenement.Dao;

import cn.tenement.Entity.category;
import cn.tenement.Entity.houseinfo;
import cn.tenement.Entity.two;

import java.util.List;

/**
 * Created by sunbin on 2017/8/30.
 */
public interface houseDao {
    public List<houseinfo> list();

    public List<houseinfo> lists(String typename);

    public int insert(houseinfo house);

    public List<houseinfo> select(int houseid);

    public List<category> one(int id);
    public List<category> two(int id);
}
