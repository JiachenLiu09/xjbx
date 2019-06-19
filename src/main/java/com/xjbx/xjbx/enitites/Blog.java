package com.xjbx.xjbx.enitites;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Tbl_blog")
@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bolgId;

    @Column(length = 20, nullable = false)
    private String blogTitle;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date createDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private Date modifiedDate;

    private Integer traffic;

    @ManyToOne(optional = false)
    @JoinColumn(name="userId")
    private User user;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "blogContentId", referencedColumnName = "blogContentId")
    private BlogContent blogContent;

    public Blog() {
    }

    public Blog(String blogTitle, Date createDate, Date modifiedDate, Integer traffic, User user, BlogContent blogContent) {
        this.blogTitle = blogTitle;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
        this.traffic = traffic;
        this.user = user;
        this.blogContent = blogContent;
    }

    public BlogContent getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(BlogContent blogContent) {
        this.blogContent = blogContent;
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
