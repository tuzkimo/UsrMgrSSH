package net.tuzkimo.ssh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.tuzkimo.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tuzkimo on 2017-03-21.
 */
@Service
public class UserAction extends ActionSupport {

    @Autowired
    private UserService userService;

    public String execute() {
        ActionContext.getContext().put("users", this.userService.getAllUsers());
        return SUCCESS;
    }

}
