package Utitls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtitls {

    public static SessionFactory sf;

    static {
        try {
            // 静态代码块，保证SessionFactory在项目运行阶段只有一个
            Configuration conf = new Configuration().configure();
            sf = conf.buildSessionFactory();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("数据库创建中.....");
    }

    public static Session openSession() {// 开启一个session

        return sf.openSession();
    }
    // 获得当前线程的session
    public static Session getCurrentSession() {
        return sf.getCurrentSession();
    }

}
