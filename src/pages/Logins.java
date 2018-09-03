package pages;

import Entity.User;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Logins extends ActionSupport {
    private static SessionFactory sessionFactory;
    private static Transaction tx;
    private static Session session;

    @Override
    public String execute() throws Exception {
            return SUCCESS;
    }

    public String goHomePage ()
    {
        return  SUCCESS;
    }
}
