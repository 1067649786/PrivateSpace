package com.lyh.zone.service;

import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.dto.ArchiveBo;
import com.lyh.zone.dto.ArticleDTO;
import com.lyh.zone.entity.TbArticle;
import com.lyh.zone.entity.TbUser;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbArticleService
 * 类描述：
 */
public interface TbArticleService extends IService<TbArticle> {

    /**
     * 分页查询所有文章
     * @return
     */
    PageInfo<TbArticle> findPageArticle(int page, int limit, TbArticle article, TbUser user);

    /**
     * 分页查询所有自己的文章
     * @param page
     * @param limit
     * @param article
     * @param user
     * @return
     */
    PageInfo<TbArticle> findPageArticleSelf(int page,int limit,TbArticle article,TbUser user);

    /**
     * 归档
     * @return
     */
    List<ArchiveBo> archives(TbUser user);

    /**
     * 文章连接查询
     * @param articleUrl
     * @return
     */
    TbArticle findByArticleUrl(String articleUrl);

    /**
     * 标题分页搜索文章
     * @param keywords
     * @param page
     * @param limit
     * @param user
     * @return
     */
    PageInfo<TbArticle> findArticleByKeywords(String keywords,Integer page,Integer limit,TbUser user);

    /**
     * 根据状态统计条数  包括自己和对方的
     * @param status
     * @param post
     * @return
     */
    Integer countByStatusAll(Integer status,String post,TbUser user);

    /**
     * 根据状态统计条数 只包括自己
     * @param status
     * @param post
     * @param user
     * @return
     */
    Integer countByStatusSelf(Integer status,String post,TbUser user);

    /**
     * 统计重复链接
     * @param articleUrl
     * @return
     */
    int findRepeatByUrl(String articleUrl);

    /**
     * 保存文章
     * @param article
     */
    void save(ArticleDTO article) throws Exception;
}
