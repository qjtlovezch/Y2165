import cn.bdqn.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by QiuShao on 2017/8/25.
 */
public class Test {
    @org.junit.Test

    public void t() {
        Student student = new Student();

        student.setName("aaa");
        student.setAge(13);
        Configuration cc=new Configuration().configure();
        SessionFactory sf=cc.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(student);
        tx.commit();
        System.out.println("+++++++++++++++++++++");
    }
}
