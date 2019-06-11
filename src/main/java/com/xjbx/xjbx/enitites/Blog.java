package com.xjbx.xjbx.enitites;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bolgId;

    @Column(length = 20, nullable = false)
    private String blogTitle;

    private Date createDate;
    private Date modifiedDate;
    private Integer traffic;

    @ManyToOne(optional = false)
    @JoinColumn(name="userId")
    private User user;

    public Blog() {
    }

    public Blog(Integer bolgId, String blogTitle, Date createDate, Date modifiedDate, Integer traffic, User user) {
        this.bolgId = bolgId;
        this.blogTitle = blogTitle;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.traffic = traffic;
        this.user = user;
    }

    public Integer getBolgId() {
        return bolgId;
    }

    public void setBolgId(Integer bolgId) {
        this.bolgId = bolgId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    @JsonBackReference
    public void setUser(User user) {
        this.user = user;
    }
}
