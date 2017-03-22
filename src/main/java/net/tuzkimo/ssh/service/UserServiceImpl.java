package net.tuzkimo.ssh.service;

import net.tuzkimo.ssh.dao.UserDao;
import net.tuzkimo.ssh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-21.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

}
