package com.lyh.zone.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.dto.ArchiveBo;
import com.lyh.zone.dto.ArticleDTO;
import com.lyh.zone.entity.TbArticle;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.mapper.TbArticleMapper;
import com.lyh.zone.service.TbArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbArticleServiceImpl
 * 类描述：
 */
@Service
public class TbArticleServiceImpl extends ServiceImpl<TbArticleMapper, TbArticle> implements TbArticleService {

    @Autowired
    private TbArticleMapper articleMapper;

    @Override
    public PageInfo<TbArticle> findPageArticle(int page, int limit, TbArticle article, TbUser user) {
        PageHelper.startPage(page,limit);
        List<TbArticle> articles=articleMapper.findPageArticle(article,user);
        return new PageInfo<>(articles);
    }

    @Override
    public PageInfo<TbArticle> findPageArticleSelf(int page, int limit, TbArticle article, TbUser user) {
        PageHelper.startPage(page,limit);
        List<TbArticle> articles=articleMapper.findPageArticleSelf(article,user);
        return new PageInfo<>(articles);
    }

    @Override
    public List<ArchiveBo> archives(TbUser user) {
        // 查询文章表各个时间段的文章数量 分别为DATE->时间段 count->文章数量
        List<ArchiveBo> listforArchiveBo = articleMapper.findDateAndCount(user);
        if (listforArchiveBo != null) {
            for (ArchiveBo archiveBo : listforArchiveBo) {
                Date sd=DateUtil.parse(archiveBo.getDate(),"yyyy年MM月");
                String[] dateSplit=sd.toString().split("-");
                StringBuilder date1=new StringBuilder(dateSplit[0]+"-"+dateSplit[1]);
                StringBuilder date2=new StringBuilder(dateSplit[0]+"-"+dateSplit[1]);
                List<TbArticle> articles=articleMapper.findAllArticle(date1.append("-01").toString(),date2.append("-31").toString(),user);
                archiveBo.setArticles(articles);
            }
        }
        return listforArchiveBo;
    }

    @Override
    public TbArticle findByArticleUrl(String articleUrl) {
        return articleMapper.findByArticleUrl(articleUrl);
    }

    @Override
    public PageInfo<TbArticle> findArticleByKeywords(String keywords, Integer page, Integer limit, TbUser user) {
        PageHelper.startPage(page,limit);
        List<TbArticle> articles=articleMapper.findArticleByKeywords(keywords,user);
        return new PageInfo<>(articles);
    }

    @Override
    public Integer countByStatusAll(Integer status, String post,TbUser user) {
        return articleMapper.countByStatusAll(status,post,user);
    }

    @Override
    public Integer countByStatusSelf(Integer status, String post, TbUser user) {
        return articleMapper.countByStatusSelf(status,post,user);
    }

    @Override
    public int findRepeatByUrl(String articleUrl) {
        return articleMapper.findRepeatByUrl(articleUrl);
    }

    @Override
    public void save(ArticleDTO article) throws Exception {
        articleMapper.insertArticle(article);
    }
}
