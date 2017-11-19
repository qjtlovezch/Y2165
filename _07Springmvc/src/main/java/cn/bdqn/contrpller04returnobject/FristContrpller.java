package cn.bdqn.contrpller04returnobject;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by QiuShao on 2017/8/14.
 */
@Controller
public class FristContrpller {
    @RequestMapping("/first")
    @ResponseBody
    public Object doOne(){
    return 1;
    }
    @RequestMapping(value = "/second",produces = "text/html;charset=utf-8")
    @ResponseBody
    public Object sss(){
        return "就业";
    }

    @RequestMapping(value = "/three")
    @ResponseBody
    public Object ssss(){
        UserInfo info=new UserInfo();
        info.setName("aaaa");
        return info;
    }

    @RequestMapping(value = "/four")
    @ResponseBody
    public Object s2(){
        Map<String,UserInfo> map=new HashMap<String, UserInfo>();
        UserInfo info=new UserInfo();
        info.setName("aaaa");
        info.setAge(12);
        UserInfo info1=new UserInfo();
        info1.setName("aaaaa");
        info1.setAge(122);
        map.put(info.getName(),info);
        map.put(info1.getName(),info1);
        return map;
    }
    @RequestMapping(value = "/five")
    @ResponseBody
    public Object dofive(){
        List<UserInfo> list=new ArrayList<UserInfo>();
        UserInfo info=new UserInfo();
        info.setName("aaaa");
        info.setAge(12);
        list.add(info);
        return list;
    }

}
