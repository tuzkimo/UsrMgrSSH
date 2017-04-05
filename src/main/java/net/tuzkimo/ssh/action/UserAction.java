package net.tuzkimo.ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import net.tuzkimo.ssh.entity.User;
import net.tuzkimo.ssh.service.UserService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
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

    private File upload;
    private String uploadFileName;
    private String savePath;

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

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public String getUploadFileName() {
        return uploadFileName;
    }

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String execute() {
        users = userService.getAllUsers();
        return SUCCESS;
    }

    public String addSave() throws IOException {
        String realPath = ServletActionContext.getServletContext().getRealPath(savePath);

        if (upload != null) {
            File saveFile = new File(realPath, getUploadFileName());

            if (!saveFile.getParentFile().exists()) {
                saveFile.getParentFile().mkdir();
            }

            FileUtils.copyFile(upload, saveFile);

            user.setPhoto(uploadFileName);
        }

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
