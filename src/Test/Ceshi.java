package Test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Entity.User;
import service.HelpDb;

public class Ceshi {

    private static SessionFactory sessionFactory;
    private static Transaction tx;
    private static Session session;

    public static void main(String[] args) {

        /* 提交测试
         第一步 加载hibernate核心配置文件
         到src下面找到名称是hibernate.cfg.xml
         在hibernate里面封装对象*/
//        try {
//
//            Configuration cfg = new Configuration();
//            cfg.configure();
//            //第二步 创建SessionFactory对象
//            // 读取hibernate核心配置文件内容，创建sessionFactory
//            // 在过程中，根据映射关系，在配置数据库里面把表创建
//            sessionFactory = cfg.buildSessionFactory();
//
//            //第三步 使用SessionFactory创建session对象
//            // 类似于连接
//            session = sessionFactory.openSession();
//
//            //第四步 开启事务
//            tx = session.beginTransaction();
//
//            //第五步 写具体逻辑 crud操作
//            // 添加功能
//            for (int i = 0; i < 10; i++) {
//                User customer = new User();
//                // 主键id自增，不用设置哈。
//                customer.setUsername("老" + i);
//                customer.setPassword("0" + i);
//                session.save(customer);
//                System.out.println(customer);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        } finally {
//
////		第六步 提交事务
//            tx.commit();
////		第七步 关闭资源
//            session.close();
//            sessionFactory.close();
//        }
        //GetUserLists();
        InsertUser();
    }

    public static void  GetUserLists()
    {
        HelpDb db =new HelpDb();
        System.out.println(db.getAllList(null));
    }

    public static void  InsertUser()
    {
        HelpDb db =new HelpDb();
        System.out.println(   "是否存在："+db.Exist("老0"));
    }
}
