package cn.bdqn.service;

import cn.bdqn.dao.IProductDAO;
import cn.bdqn.entity.Product;
import cn.bdqn.entity.Takeout;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/28.
 */
@Service("productservice")
public class ProductServiceImpl implements IProductService {
    @Resource(name = "IProductDAO")
    IProductDAO dao;

    public List<Product> getAll() {
        return dao.getAll();
    }

    public int padd(Takeout takeout) {
        return dao.padd(takeout);
    }

    public int upd(Product product) {
        return dao.upd(product);
    }

    public List<Product> doid(int id) {
        return dao.doid(id);
    }


}

