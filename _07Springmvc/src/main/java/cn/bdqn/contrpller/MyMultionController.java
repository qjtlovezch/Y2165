package cn.bdqn.contrpller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by QiuShao on 2017/8/16.
 */
public class MyMultionController extends MultiActionController{
    public ModelAndView insert(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("insert");
        return mv;
    }

    public ModelAndView delete(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv=new ModelAndView();
        mv.setViewName("delete");
        return mv;
    }
}
