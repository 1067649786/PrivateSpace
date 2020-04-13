package com.lyh.zone.dto;

import java.util.Date;

/**
 * 项目名称：zone
 * 类名称：ArticleDTO
 * 类描述：
 */
public class ArticleDTO {

    private Integer uid;

    private String content;

    private String contentMd;

    private Date newstime;

    private Integer status;

    private String summary;

    private String thumbnail;

    private String title;

    private Integer type;

    private String post;

    private Integer comment;

    private Date updatetime;

    private String url;

    private Long views;

    public ArticleDTO(Integer uid, String content, String contentMd, Date newstime, Integer status, String summary, String thumbnail, String title, Integer type, String post, Integer comment, Date updatetime, String url, Long views) {
        this.uid = uid;
        this.content = content;
        this.contentMd = contentMd;
        this.newstime = newstime;
        this.status = status;
        this.summary = summary;
        this.thumbnail = thumbnail;
        this.title = title;
        this.type = type;
        this.post = post;
        this.comment = comment;
        this.updatetime = updatetime;
        this.url = url;
        this.views = views;
    }

    public ArticleDTO() {
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentMd() {
        return contentMd;
    }

    public void setContentMd(String contentMd) {
        this.contentMd = contentMd;
    }

    public Date getNewstime() {
        return newstime;
    }

    public void setNewstime(Date newstime) {
        this.newstime = newstime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
