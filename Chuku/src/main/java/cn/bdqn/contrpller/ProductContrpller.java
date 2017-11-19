package cn.bdqn.contrpller;

import cn.bdqn.entity.Product;
import cn.bdqn.entity.Takeout;
import cn.bdqn.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/28.
 */
@Controller
public class ProductContrpller {
    @Resource(name = "productservice")
    IProductService productService;

    @RequestMapping("/dolist")
    public String dolist(HttpSession session, HttpServletResponse response) throws IOException {
        List<Product> list=productService.getAll();
        session.setAttribute("list",list);
        //response.getWriter().write("<srcipt>alert('aa');location.href=</script>");
        return "/jsp/index.jsp";

    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String doadd(Takeout takeout,Model model){
        if(takeout.getQuantity()>20){
            model.addAttribute("myuicount",takeout.getQuantity());
            model.addAttribute("id",takeout.getProductid());
            model.addAttribute("name",takeout.getHandler());
            model.addAttribute("mycount",20);
            model.addAttribute("result",false);
            return "/dolist";
        }else {
            takeout.setOutdate(new Date());
            takeout.setProductid(takeout.getProductid());
            int padd = productService.padd(takeout);
            if (padd > 0) {
                return "/doupd";
            } else {
                return "/add";
            }
        }

    }
    @RequestMapping("/doupd")
    public String doupd(Product product ,String quantity){
        int upd = productService.upd(product);
        if (upd>0){
            return "dolist";
        }else{
            return "doupd";
        }
    }

}
