package com.lyh.zone.common.enums;

/**
 * 项目名称：zone
 * 类名称：ArticleStatus
 * 类描述：文章状态
 */
public enum ArticleStatus {
    PUBLISH(0,"已发布"),
    DRAFT(1,"草稿"),
    RECYCLE(2,"回收站")
    ;

    private Integer status;
    private String desc;

    ArticleStatus(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
