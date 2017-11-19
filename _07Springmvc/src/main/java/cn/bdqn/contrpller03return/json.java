package cn.bdqn.contrpller03return;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/18.
 */
@Controller
public class json {
@RequestMapping("/tojson")
    public void write(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<UserInfo> list=new ArrayList<UserInfo>();
    UserInfo u1=new UserInfo();
    u1.setName("啊啊");
    u1.setAge(22);

    UserInfo u2=new UserInfo();
    u2.setName("哈哈");
    u2.setAge(20);

    list.add(u1);
    list.add(u2);


   // String re= JSON.toJSONString(list);

   // response.getWriter().write(re);



    }

}
