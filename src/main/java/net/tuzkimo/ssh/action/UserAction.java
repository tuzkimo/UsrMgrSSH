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

    private File photo;
    private String photoFileName;
    private String path;

    private String message;

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

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String execute() {
        users = userService.getAllUsers();
        return SUCCESS;
    }

    public String addSave() throws IOException {
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

    public String upPhoto() {
        user = userService.getUserById(id);
        return SUCCESS;
    }

    public String upPhotoSave() {

        // 非空验证
        if (photo == null) {
            setMessage("Please upload a photo.");
            return INPUT;
        }

        // 文件类型验证
        if (!(photoFileName.endsWith(".jpg") || photoFileName.endsWith(".png"))) {
            setMessage("Sorry, we only accept jpg or png file.");
            return INPUT;
        }

        // 获取目标用户
        user = userService.getUserById(id);

        // 获取储存路径
        String savePath = ServletActionContext.getServletContext().getRealPath(path);

        // 创建本地保存文件
        File savePhoto = new File(savePath, photoFileName);

        // 本地保存路径不存在则新建文件夹
        if (!savePhoto.getParentFile().exists()) {
            savePhoto.getParentFile().mkdir();
        }

        try {

            // 上传文件保存到服务器本地
            FileUtils.copyFile(photo, savePhoto);

            // 更新服务器记录
            user.setPhoto(photoFileName);

            // 更新数据库记录
            userService.editUser(user);

        } catch (IOException e) {
            e.printStackTrace();
            return INPUT;
        }

        return SUCCESS;

    }

}
