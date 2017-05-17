package net.tuzkimo.ssh.dao;

import net.tuzkimo.ssh.entity.User;

import java.util.List;

/**
 * 用户 DAO 接口
 * Created by tuzkimo on 2017-03-21.
 */
public interface UserDao {

    User getUserById(int id);

    List<User> getAllUsers();

    List getUsersPaper(int skip, int size);

    Long getUsersCount();

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean deleteUserById(int id);

    User getUserByName(String name);

    List<User> nativeSQL(int first, int last);
    
}
