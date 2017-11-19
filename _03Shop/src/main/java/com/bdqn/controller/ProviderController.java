package com.bdqn.controller;

import com.bdqn.pojo.Bill;
import com.bdqn.pojo.Provider;
import com.bdqn.service.ProviderServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by java on 2017-9-7.
 */
@Controller
public class ProviderController {
    //植入ProviderService对象
    @Resource(name = "providerService")
    ProviderServiceImpl   proimpl;

    @RequestMapping("/prolist")     //列表及分页
    public String doP(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,4);
        List<Provider> sll=proimpl.getPro();
        PageInfo page=new PageInfo(sll,4);
        model.addAttribute("page",page);
        return "providerList";
    }

  /*  @RequestMapping("/Proid/{id}")   //根据id查询
    public  String doPro(HttpServletRequest request, @PathVariable int id){
          Provider   p=proimpl.Pid(id);
           request.setAttribute("list",p);
           return "providerView";
    }
*/
  @RequestMapping("/Pupda/{id}")  //根据id查询，进行修改传值
    public String Dop(HttpServletRequest request,@PathVariable int id){
          Provider pr=proimpl.Pupdate(id);
          request.setAttribute("li",pr);
          return "providerUpdate";
  }


  @RequestMapping("/doupdate/{id}")  //修改
    public String Dopl(String  proCode,String  proName,String  proAddress,String  proDesc,String  proContact,String  proPhone,String  proFax,Date creationDate,@PathVariable int id){
        Provider  p=new Provider();
        p.setProCode(proCode);
        p.setProAddress(proAddress);
        p.setProName(proName);
        p.setProDesc(proDesc);
        p.setProContact(proContact);
        p.setProPhone(proPhone);
        p.setProFax(proFax);
        p.setCreationDate(creationDate);
        p.setId(id);
        int count=proimpl.update(p);
        if(count>0){
            return "redirect:/prolist";
        }else {
            return "providerUpdate";
        }
  }


@RequestMapping("/Pdel/{id}")      //删除
    public String Dodel(@PathVariable int id){
        proimpl.delete(id);
        return "redirect:/prolist";
}


@RequestMapping("/ADD")   //添加页面
public String DOA(){
        return "providerAdd";
}

@RequestMapping("/Inter")  //添加
    public  String  DoInt(Provider pp){
     Provider p=new Provider();
  p.setProCode(pp.getProCode());
     p.setProName(pp.getProName());
     p.setProContact(pp.getProContact());
     p.setProPhone(pp.getProPhone());
     p.setProAddress(pp.getProAddress());
     p.setProFax(pp.getProFax());
     p.setProDesc(pp.getProDesc());
    int  count=proimpl.insert(p);
    if(count>0){
        return "redirect:/prolist";
    }else {
        return "providerAdd";
    }
    }

    @RequestMapping("/dmel")   //模糊查询
   /* public String doMU(HttpServletRequest request,String proname){
        List<Provider> list=proimpl.Mtell(proname);
        request.setAttribute("list",list);
        return "providerList";
    }*/
    public String doP(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,String proName){
        PageHelper.startPage(pn,4);
        List<Provider> sll=proimpl.Mtell(proName);
        PageInfo page=new PageInfo(sll,4);
        model.addAttribute("page",page);
        return "providerList";
    }
}
