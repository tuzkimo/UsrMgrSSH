package net.tuzkimo.ssh.entity;

import javax.persistence.*;

/**
 * 用户实体
 * Created by tuzkimo on 2017-03-20.
 */
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    private String description;
    private String photo = "default.jpg";

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, String description) {
        this.name = name;
        this.password = password;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", description='" + description + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }

}
