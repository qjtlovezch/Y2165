package com.bdqn.controller;

import com.bdqn.pojo.Bill;
import com.bdqn.pojo.User;
import com.bdqn.service.BillService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by java on 2017-9-5.
 */
@Controller
public class BillController {
    //植入BillService
    @Resource(name = "billservice")
    BillService  biservice;



    @RequestMapping("/getbill")  //列表及分页
    public String  doList(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,4);
        List<Bill> sll=biservice.getBill();
        PageInfo page=new PageInfo(sll,4);
        model.addAttribute("page",page);
        return "billList";
    }

    @RequestMapping("/getbills")  //多条件查询加分页
    public String  doList(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,String productName,int providerId,int isPayment){
        System.out.println("--------------------------");
        PageHelper.startPage(pn,4);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("productName",productName);
        params.put("providerId",providerId);
        params.put("isPayment",isPayment);
        List<Bill> sll = biservice.getBills(params);
        System.out.println(productName);
        System.out.println(providerId);
        System.out.println(isPayment);
        PageInfo page=new PageInfo(sll,4);
        model.addAttribute("page",page);
        return "billList";
    }

/*根据id查询*/
@RequestMapping("/billuser/{id}")
    public  String  doBil(HttpServletRequest request, @PathVariable int id){
      Bill  bu=biservice.biuest(id);
      request.setAttribute("list",bu);
        return  "billView";
}

/*添加页面*/
@RequestMapping("/addf")
public String  dos(){
    return "billAdd";
}

@RequestMapping("/addbiill")
    public String doAd(Bill bill){
   Bill b=new Bill();
   b.setBillCode(bill.getBillCode());
   b.setProductName(bill.getProductName());
   b.setProductUnit(bill.getProductUnit());
   b.setProductCount(bill.getProductCount());
   b.setTotalPrice(bill.getTotalPrice());
   b.setProviderId(bill.getProviderId());
   b.setIsPayment(bill.getIsPayment());
   b.setCreationDate(new Date());

   int  count=biservice.Addbill(b);
   if(count>0){
       return "redirect:/getbill";
   }else {
       return "billAdd";
   }
}

/*根据id进行查询，修改的传值*/
@RequestMapping("/CBill/{id}")
    public  String  doC(HttpServletRequest request,@PathVariable int id){
       Bill  bi=biservice.getb(id);
       request.setAttribute("list",bi);
       return "billUpdate";
}

/*修改*/
@RequestMapping("/upda/{id}")
    public String doUp( String  billCode,String  productName,String  productUnit,Float  productCount,Float totalPrice,int  providerId,int  isPayment,@PathVariable int id){
    Bill  bl=new Bill();
    bl.setBillCode(billCode);
    bl.setProductName(productName);
    bl.setProductUnit(productUnit);
    bl.setProductCount(productCount);
    bl.setTotalPrice(totalPrice);
    bl.setProviderId(providerId);
    bl.setIsPayment(isPayment);
    bl.setId(id);
    int coun=biservice.Bupdate(bl);
    if(coun>0){
        return "redirect:/getbill";
    }else {
        return "billUpdate";
    }
}


/*删除*/
@RequestMapping("/Bdel/{id}")
    public String doB(@PathVariable int id){
         biservice.Bdelete(id);
         return "redirect:/getbill";
}

}
