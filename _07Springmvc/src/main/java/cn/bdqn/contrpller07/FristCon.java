package cn.bdqn.contrpller07;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created by QiuShao on 2017/8/27.
 */
@Controller
public class FristCon {

    @ExceptionHandler(TypeMismatchException.class)
    public ModelAndView pae(TypeMismatchException ex, HttpServletRequest request){
        System.out.println("aaaaaaa");
        ModelAndView mv=new ModelAndView();
        mv.addObject("mydata",request.getParameter("birthday"));
        mv.setViewName("/type.jsp");
        return mv;
    }

    @RequestMapping("/one")
    public String doone(Date birthday,int age){
        System.out.println(birthday+"+++++");
        System.out.println(age+"----");
        return "/index.jsp";
    }















}
