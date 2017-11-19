package cn.bdqn.contrpller06Execept;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by QiuShao on 2017/8/21.
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver{
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView mv=new ModelAndView();
        if(ex instanceof NameException){
            mv.addObject("ex",ex);
            mv.setViewName("nameerrors.jsp");

        }
        if(ex instanceof AgeException){
            mv.addObject("ex",ex);
            mv.setViewName("ageerrors.jsp");

        }
        return mv;
    }
}
