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
 * 用户测试类
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
//        Assert.assertTrue("Expected a user with #1!", user.getId() == 1);
        System.out.println(user);
    }

    @Test
    public void getAllUsersTest() {
        List<User> users = this.userService.getAllUsers();
        System.out.println(users);
    }

    @Test
    public void addUserTest() throws Exception {
        User user = new User("Steve Curry", "password", "PG");
        boolean result = userService.addUser(user);
        System.out.println("Added user? " + result);
    }

    @Test
    public void editUserTest() throws Exception {
        User user = userService.getUserById(7);
        user.setPassword("sc123456");
        boolean result = userService.editUser(user);
        System.out.println("Edited user? " + result);
    }

    @Test
    public void deleteUserTest() throws Exception {
        boolean result = userService.deleteUserById(7);
        System.out.println("Deleted user? " + result);
    }

}
