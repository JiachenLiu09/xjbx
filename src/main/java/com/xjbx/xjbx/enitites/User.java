package com.xjbx.xjbx.enitites;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 100)
    private Integer userId;

    @Column(unique = true, nullable = false, updatable = false, length = 60)
    private String userName;

    @Column(nullable = false, length = 60)
    private String userPassword;

    @Column(length = 10)
    private String gender;
    private Date userBirthday;
    private String userDescription;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Blog> blogList;

    public User() {
    }

    public User(String userName, String userPassword, String gender, Date userBirthday, String userDescription, List<Blog> blogList) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.gender = gender;
        this.userBirthday = userBirthday;
        this.userDescription = userDescription;
        this.blogList = blogList;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
