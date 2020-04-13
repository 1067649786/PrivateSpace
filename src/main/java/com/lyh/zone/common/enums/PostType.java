package com.lyh.zone.common.enums;

/**
 * 项目名称：zone
 * 类名称：PostType
 * 类描述：
 */
public enum PostType {

    /**
     * 文章
     */
    POST_TYPE_POST("post"),
    /**
     * 页面
     */
    POST_TYPE_PAGE("page")
    ;

    private String value;

    PostType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
