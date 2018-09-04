package service;


import Entity.User;
import org.hibernate.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.math.BigInteger;
import java.util.List;

/**
 * 实现该接口的类
 */
public class HelpDb implements UserServiceExtends {

    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public HelpDb() {

        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();

        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
            e.printStackTrace();
            System.out.println("EmployeeDaoImpl error");

        } finally {

            if (session != null) {
                session.close();
            }
        }
    }


    /**
     * @return
     */
    public boolean Exist(String id) {
        try {
            session = sessionFactory.openSession();
            //参数化写法
            String sql = "select uid FROM User where username = ?";
            SQLQuery query = session.createSQLQuery(sql);
            query.setParameter(0, id);
            List list = query.list();
            return list.size() > 0 ? true : false;

        } catch (Exception e) {
            if (transaction != null) {
                //   transaction.rollback();
            }
            return false;

        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    @Override
    public List<User> getAllList(User entity) {

        List<User> employees = null;
        try {

            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            //HQL运行执行的是实体类名， 而不是数据库的表明
            employees = session.createQuery("select uid,username,password FROM User").list();
            System.out.println("数据查询中.....");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            employees = null;
            System.out.println("*******");
            e.printStackTrace();
            System.out.println("数据库查询失败........");

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return employees;

    }

    @Override
    public boolean save(User entity) {


        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            result = false;
            e.printStackTrace();
            System.out.println("public boolean save(Employee entity) error");

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;
    }

    @Override
    public boolean update(User entity) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            result = false;
            e.printStackTrace();
            System.out.println("public boolean update(Employee entity) error");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;

    }

    @Override
    public boolean delete(User entity) {
        boolean result = false;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            result = false;
            e.printStackTrace();
            System.out.println("public boolean delete(Employee entity) error");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return result;

    }
}