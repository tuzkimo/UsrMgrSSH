package net.tuzkimo.ssh.service;

import net.tuzkimo.ssh.dao.UserDao;
import net.tuzkimo.ssh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现类
 * Created by tuzkimo on 2017-03-21.
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean editUser(User user) {
        return userDao.updateUser(user);
    }

    public boolean deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }

}
