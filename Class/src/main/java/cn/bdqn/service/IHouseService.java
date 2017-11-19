package cn.bdqn.service;

import cn.bdqn.entity.Category;
import cn.bdqn.entity.Houseinfo;
import cn.bdqn.entity.Housetype;

import java.util.List;

public interface IHouseService {
    public List<Houseinfo> houselist();
    public List<Housetype>typelist();
    public int inser(Houseinfo houseinfo);
    public List<Houseinfo>infolist(int id);
    public List<Houseinfo>infolists(String housedesc);
    public List<Category> selectAllCate(Integer id);

    public  List<Category> allCateType();

}
