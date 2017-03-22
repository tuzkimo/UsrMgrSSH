package net.tuzkimo.ssh.test;

import net.tuzkimo.ssh.entity.User;
import net.tuzkimo.ssh.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by tuzkimo on 2017-03-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml"})
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByIdTest() {
        User user = this.userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getAllUsersTest() {
        List<User> users = this.userService.getAllUsers();
        System.out.println(users);
    }

}
