package net.tuzkimo.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import net.tuzkimo.ssh.entity.User;
import net.tuzkimo.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 Action
 * Created by tuzkimo on 2017-03-21.
 */
@Service
public class UserAction extends ActionSupport {

    private static final long serialVersionUID = 4498877919741231945L;

    private final UserService userService;

    private Integer id;
    private User user;
    private List<User> users;

    @Autowired
    public UserAction(UserService userService) {
        this.userService = userService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String execute() {
        users = userService.getAllUsers();
        return SUCCESS;
    }

    public String addSave() {
        if (!userService.addUser(user)) {
            return INPUT;
        }
        return SUCCESS;
    }

    public String edit() {
        user = userService.getUserById(id);
        return SUCCESS;
    }

    public String editSave() {
        if (!userService.editUser(user)) {
            return INPUT;
        }
        return SUCCESS;
    }

    public String delete() {
        userService.deleteUserById(id);
        return SUCCESS;
    }

}
