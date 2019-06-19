package com.xjbx.xjbx.enitites;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "Tbl_user")
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
    private String userGender;
    private Date userDOB;
    private String userDescription;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Blog> blogList;

    private String userAvatar;

    public User() {
    }

    public User(String userName, String userPassword, String userGender, Date userDOB, String userDescription, List<Blog> blogList, String userAvatar) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userGender = userGender;
        this.userDOB = userDOB;
        this.userDescription = userDescription;
        this.blogList = blogList;
        this.userAvatar = userAvatar;
    }

    public String getUserGender() {
        return userGender;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
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

    public String getUserGenderr() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Date getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(Date userBirthday) {
        this.userDOB = userBirthday;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
