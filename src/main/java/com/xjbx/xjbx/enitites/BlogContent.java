package com.xjbx.xjbx.enitites;

import javax.persistence.*;
import java.util.Date;

@Table(name = "Tbl_blogContent")
@Entity
public class BlogContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogContentId;

    private String content;
    private Date createDate;
    private Date modifiedDate;

    public BlogContent() {
    }

    public BlogContent(Integer blogContentId, String content, Date createDate, Date modifiedDate) {
        this.blogContentId = blogContentId;
        this.content = content;
        this.createDate = createDate;
        this.modifiedDate = modifiedDate;
    }

    public Integer getBlogContentId() {
        return blogContentId;
    }

    public void setBlogContentId(Integer blogContentId) {
        this.blogContentId = blogContentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
}
