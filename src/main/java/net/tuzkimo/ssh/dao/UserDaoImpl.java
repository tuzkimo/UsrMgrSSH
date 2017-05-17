package net.tuzkimo.ssh.dao;

import net.tuzkimo.ssh.entity.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
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

    @SuppressWarnings("JpaQlInspection")
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

    @SuppressWarnings("unchecked")
    public User getUserByName(String name) {
        return (User) getCurrentSession()
                .createQuery("FROM User WHERE name = :name")
                .setParameter("name", name).setMaxResults(1).uniqueResult();
    }

    public List<User> nativeSQL(int first, int last) {
        String sql = "SELECT * FROM (SELECT a.*, ROWNUM rn FROM (SELECT * FROM TBL_USER ORDER BY ID) a WHERE ROWNUM <= :last ) b WHERE rn >= :first";
        SQLQuery sqlQuery = getCurrentSession().createSQLQuery(sql);
        sqlQuery.addEntity(User.class);
        sqlQuery.setParameter("first", first);
        sqlQuery.setParameter("last", last);
        List<User> users = (List<User>) sqlQuery.list();
        return users;
    }

}
