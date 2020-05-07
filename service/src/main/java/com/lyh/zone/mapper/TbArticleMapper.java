package com.lyh.zone.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lyh.zone.dto.ArchiveBo;
import com.lyh.zone.dto.ArticleDTO;
import com.lyh.zone.entity.TbArticle;
import com.lyh.zone.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbArticleMapper
 * 类描述：
 */
@Repository
public interface TbArticleMapper extends BaseMapper<TbArticle> {

    List<TbArticle> findPageArticle(@Param("article") TbArticle article,@Param("user") TbUser user);

    List<TbArticle> findPageArticleSelf(@Param("article") TbArticle article,@Param("user") TbUser user);

    List<ArchiveBo> findDateAndCount(@Param("user") TbUser user);

    List<TbArticle> findAllArticle(@Param("date1") String date1,@Param("date2") String date2,@Param("user") TbUser user);

    TbArticle findByArticleUrl(@Param("articleUrl") String articleUrl);

    List<TbArticle> findArticleByKeywords(@Param("keywords") String keywords,@Param("user") TbUser user);

    Integer countByStatusAll(@Param("status") Integer status,@Param("post") String post,@Param("user") TbUser user);

    Integer countByStatusSelf(@Param("status") Integer status,@Param("post") String post,@Param("user") TbUser user);

    int findRepeatByUrl(String articleUrl);

    int insertArticle(ArticleDTO article);
}
