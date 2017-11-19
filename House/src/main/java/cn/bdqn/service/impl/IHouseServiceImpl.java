package cn.bdqn.service.impl;

import cn.bdqn.dao.IHouseDAO;
import cn.bdqn.entity.Houseinfo;
import cn.bdqn.entity.Housetype;
import cn.bdqn.service.IHouseService;
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

    public int addhouse(Houseinfo houseinfo) {
        return dao.addhouse(houseinfo);
    }

    public List<Housetype> getall() {
        return dao.getall();
    }

    public IHouseDAO getDao() {
        return dao;
    }

    public void setDao(IHouseDAO dao) {
        this.dao = dao;
    }

}
