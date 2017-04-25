package net.tuzkimo.ssh.service;

import net.tuzkimo.ssh.entity.User;

import java.util.List;

/**
 * 用户服务接口
 * Created by tuzkimo on 2017-03-21.
 */
public interface UserService {

    User getUserById(int id);

    List<User> getAllUsers();

    List<User> getUsersPaper(int skip, int size);

    Long getUsersCount();

    boolean addUser(User user);

    boolean editUser(User user);

    boolean deleteUserById(int id);

}
