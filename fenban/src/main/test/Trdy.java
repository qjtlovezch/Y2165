import cn.bdqn.entity.studentattendance;
import cn.bdqn.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by QiuShao on 2017/8/16.
 */
public class    Trdy {
    @Test
    public void test() throws ParseException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContextuser.xml");
        IUserService service = (IUserService) ctx.getBean("userService");
        String date="2017-08-11";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(date);
        System.out.println(parse);
        List<studentattendance> allByTime = service.getAllByTime(parse);
       for (studentattendance time:allByTime){
           System.out.println(time.getStu().getStudentname());
       }
    }
}
