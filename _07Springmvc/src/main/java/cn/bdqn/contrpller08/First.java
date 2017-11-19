package cn.bdqn.contrpller08;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.net.BindException;

/**
 * Created by QiuShao on 2017/8/30.
 */
@Controller
public class First {
    @RequestMapping("/one")
    public ModelAndView dofirrst(@Valid User user, BindingResult br){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("/index.jsp");
        int errorCount = br.getErrorCount();
        if (errorCount>0){
            FieldError score=br.getFieldError("score");
            FieldError name=br.getFieldError("name");
            FieldError phone=br.getFieldError("phone");
            if (score!=null){
                mv.addObject("scoremsg",score.getDefaultMessage());
            }
            if (name!=null){
                mv.addObject("namemsg",name.getDefaultMessage());
            }
            if (phone!=null){
                mv.addObject("phonemsg",phone.getDefaultMessage());
            }
            mv.setViewName("/shuju.jsp");
        }
        return mv;
    }
}
