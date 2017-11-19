package cn.bdqn.test;

import cn.bdqn.entity.Student;
import cn.bdqn.service.IStudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by QiuShao on 2017/8/9.
 */
public class test {
    @Test
    public void ss(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        IStudentService service = (IStudentService) ctx.getBean("studentService");
        List<Student> stu=service.getAll();
        for (Student item:stu) {
            System.out.println(item.getsName());
        }
    }
}
