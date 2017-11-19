package com.bdqn.service;

import com.bdqn.dao.BillDao;
import com.bdqn.pojo.Bill;
import com.bdqn.service.BillService;
import com.bdqn.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by java on 2017-9-5.
 */
@Service(value = "billservice")
public class BillServiceimpl implements BillService {
    @Resource
    BillDao  dao;

    public List<Bill> getBill() {   //列表及分页
        return dao.getBill();
    }

    public Bill biuest(int id) {
        return dao.biuest(id);
    }

    public int Addbill(Bill bill) {
        return dao.Addbill(bill);
    }

    public Bill getb(int id) {
        return dao.getb(id);
    }

    public int Bupdate(Bill id) {
        return dao.Bupdate(id);
    }

    public int Bdelete(int id) {
        return dao.Bdelete(id);
    }

    public List<Bill> getBills(Map<String, Object> map) {
        return dao.getBills(map);
    }

   /* public List<Bill> getBills(String productName, int providerId, int isPayment) {
        return dao.getBills(productName,providerId,isPayment);
    }*/


}
