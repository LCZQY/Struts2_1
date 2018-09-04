package service;

import Entity.User;

import java.util.List;

public interface UserService<T> {

    // 获取所有的数据
    public List<User> getAllList(T entity);

    /**
     *  保存数据
     * @param entity
     * @return
     */
    public  boolean save(T entity);

    /**
     * 更新一个T实例
     * @param entity
     * @return 更新成功返回True否则false
     */
    boolean update(T entity);

    /**
     * 删除T实例
     * @param entity
     * @return 成功返回true，失败false
     */
    boolean delete(T entity);




}
