package pages;

import Entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.corba.se.impl.oa.poa.POAPolicyMediatorImpl_NR_UDS;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import service.HelpDb;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class Logins extends ActionSupport {

    private static SessionFactory sessionFactory;
    private static Transaction tx;
    private static Session session;
    private static HelpDb db = new HelpDb();

    @Override
    public String execute() throws Exception {

        return SUCCESS;
    }

    public String goHomePage() {
        // 获取表单数据
        return SUCCESS;
    }

    /**
     * 登陆操作
     * @return
     */
    public String gologinPage() {

        // 获取表单数据
        HttpServletRequest request = ServletActionContext.getRequest();
        String name = request.getParameter("name");
        System.out.println(request.getParameter("name") + ">>>>>>>>>>>>>>>>>");

        if (db.Exist(name)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    /**
     * * 注册页面
     *
     * @return
     */
    public String registerPage() {

        return SUCCESS;
    }

    /**
     * 注册插入数据
     * @return
     */
    public String InsertModel() {
        try {

            User insertUser = new User();
            HttpServletRequest request = ServletActionContext.getRequest();
            insertUser.setUsername(request.getParameter("name"));
            insertUser.setPassword(request.getParameter("pwd"));
            if (!db.save(insertUser)) {
                System.out.println("数据添加失败 >>>>>>>>>>");
                return ERROR;
            }
            return SUCCESS;

        } catch (Exception e) {
            e.printStackTrace();
            return ERROR;
        }
    }


    /**
     * 展示所有数据
     * @return
     */
    public String listUser() {

        HelpDb db = new HelpDb();
        List<User> emplist= db.getAllList(null);

        ActionContext.getContext().put("emplist",emplist);

        return SUCCESS;
    }


    /**
     *  删除操作
     * @return
     */
     public String user_id;
     public String userDelete()
     {

         System.out.println(user_id+" 得到你了，》》》》》》》》》》》》》");
        return SUCCESS;
     }

}
