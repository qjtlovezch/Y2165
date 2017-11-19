package cn.bdqn.dao;

import cn.bdqn.entity.Houseinfo;
import cn.bdqn.entity.Housetype;

import java.util.List;


public interface IHouseDAO {
    public List<Houseinfo> houselist();
    public int addhouse(Houseinfo houseinfo);
    public List<Housetype> getall();
}
