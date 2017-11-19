package cn.smbms.controller;

import cn.smbms.entity.Provider;
import cn.smbms.service.IProviderService;
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
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/25.
 */
@Controller
@RequestMapping("/provider")
public class ProviderController {
    @Resource(name="providerservice")
    IProviderService providerservice;
    //供应商列表
    @RequestMapping("/provlist")
    public String provlist(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //从第一条开始每页3条
        PageHelper.startPage(pn,3);
        List<Provider> prolist = providerservice.prolist();
        PageInfo page=new PageInfo(prolist,3);
        model.addAttribute("page",page);
        return "providerList";
    }

    //删除
    @RequestMapping(value = "/delpro/{id}",method = RequestMethod.GET)
    public String delpro(@PathVariable("id") int id) {
        int prodel = providerservice.prodel(id);
        if (prodel>0){
            return "redirect:/provider/provlist";
        }
        return "providerList";
    }

    //根据id查询
    @RequestMapping(value = "/idlist/{id}",method = RequestMethod.GET)
    public String idlist(HttpSession session, @PathVariable int id){
        List<Provider> proidlist = providerservice.idlist(id);
        session.setAttribute("proidlist",proidlist);
        return "providerView";
    }

    @RequestMapping("/prolike")
    //模糊
    public String provlikelist(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model,Provider provider){
        //从第一条开始每页3条
        PageHelper.startPage(pn,3);
        List<Provider> prolike = providerservice.prolike(provider);
        PageInfo page=new PageInfo(prolike,3);
        model.addAttribute("page",page);
        return "providerList";
    }

    //添加
    @RequestMapping(value = "/addpro",method = RequestMethod.POST)
    public String proadd(Provider provider){
        int proadd = providerservice.proadd(provider);
        if (proadd>0){
            return "redirect:/provider/provlist";
        }else {
            return "providerAdd";
        }
    }

    //根据id查询，进行修改传值
    @RequestMapping("/Pupda/{id}")
    public String Dop(HttpServletRequest request, @PathVariable int id){
        Provider pr=providerservice.Pupdate(id);
        request.setAttribute("li",pr);
        return "providerUpdate";
    }

    //修改
    @RequestMapping("/update/{id}")
    public String Dopl(String  proCode, String  proName, String  proAddress, String  proDesc, String  proContact, String  proPhone, String  proFax, Date creationDate, @PathVariable int id){
        Provider p=new Provider();
        p.setProCode(proCode);
        p.setProAddress(proAddress);
        p.setProName(proName);
        p.setProDesc(proDesc);
        p.setProContact(proContact);
        p.setProPhone(proPhone);
        p.setProFax(proFax);
        p.setCreationDate(creationDate);
        p.setId(id);
        int count=providerservice.update(p);
        if(count>0){
            return "redirect:/provider/provlist";
        }else {
            return "providerUpdate";
        }
    }

}
