package net.tuzkimo.ssh.dao;

import net.tuzkimo.ssh.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 DAO 实现类
 * Created by tuzkimo on 2017-03-21.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getUserById(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return getCurrentSession().createQuery("FROM User").list();
    }

    public List<User> getUsersPaper(int skip, int size) {
        return getCurrentSession().createQuery("FROM User", User.class)
                .setFirstResult(skip).setMaxResults(size)
                .list();
    }

    public Long getUsersCount() {
        return (Long) getCurrentSession().createQuery("select count(id) from User").uniqueResult();
    }

    public boolean addUser(User user) {
        Integer effectRows = (Integer) getCurrentSession().save(user);
        return effectRows >= 0;
    }

    public boolean updateUser(User user) {
        try {
            getCurrentSession().saveOrUpdate(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteUserById(int id) {
        try {
            User user = getUserById(id);
            getCurrentSession().delete(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
