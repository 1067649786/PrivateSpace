package com.lyh.zone.dto;

import com.lyh.zone.entity.TbArticle;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名称：zone
 * 类名称：ArchiveBo
 * 类描述：
 */
public class ArchiveBo implements Serializable {
    private static final long serialVersionUID = 5838966077062702007L;
    private String date;
    private List<TbArticle> articles;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<TbArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<TbArticle> articles) {
        this.articles = articles;
    }
}
