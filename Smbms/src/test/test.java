import cn.smbms.dao.IUserInfoDAO;
import cn.smbms.service.IUserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by QiuShao on 2017/8/24.
 */
public class test {
    @Test
    public void te(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IUserInfoService service = (IUserInfoService) ctx.getBean("userService");

    }
}
