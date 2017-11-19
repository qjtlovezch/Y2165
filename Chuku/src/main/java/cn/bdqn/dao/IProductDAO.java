package cn.bdqn.dao;

import cn.bdqn.entity.Product;
import cn.bdqn.entity.Takeout;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/28.
 */
public interface IProductDAO {
    //查询所有商品
    public List<Product> getAll();
    //添加
    public int padd(Takeout takeout);
    //修改
    public int upd(Product product);
    //根据ID查询库存
    public List<Product> doid(int id);

}
