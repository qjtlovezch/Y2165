package cn.bdqn.service;

import cn.bdqn.dao.IHouseDAO;


import cn.bdqn.entity.Category;
import cn.bdqn.entity.Houseinfo;
import cn.bdqn.entity.Housetype;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("houseservice")
public class IHouseServiceImpl implements IHouseService {
@Resource(name = "IHouseDAO")

IHouseDAO dao;


    public List<Houseinfo> houselist() {
        return dao.houselist();
    }

    public List<Housetype> typelist() {
        return dao.typelist();
    }

    public int inser(Houseinfo houseinfo) {
        return dao.inser(houseinfo);
    }

    public List<Houseinfo> infolist(int id) {
        return dao.infolist(id);
    }

    public List<Houseinfo> infolists(String housedesc) {
        return dao.infolists(housedesc);
    }

    public List<Category> selectAllCate(Integer id) {
        return dao.selectAllCate(id);
    }

    public List<Category> allCateType() {
        return dao.allCateType();
    }






    public IHouseDAO getDao() {
        return dao;
    }

    public void setDao(IHouseDAO dao) {
        this.dao = dao;
    }

}
