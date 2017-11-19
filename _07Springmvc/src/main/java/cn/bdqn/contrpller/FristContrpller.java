package cn.bdqn.contrpller;



import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;

/**
 * Created by QiuShao on 2017/8/14.
 */
public class FristContrpller implements Controller {



    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();

        mv.addObject("name","邱少");
        mv.setViewName("1");
        return mv;

    }
}
