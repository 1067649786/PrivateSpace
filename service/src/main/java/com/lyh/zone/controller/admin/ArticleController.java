package com.lyh.zone.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.common.base.JsonResult;
import com.lyh.zone.common.enums.ArticleStatus;
import com.lyh.zone.common.enums.MaydayEnums;
import com.lyh.zone.common.enums.PostType;
import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.controller.BaseController;
import com.lyh.zone.dto.ArticleDTO;
import com.lyh.zone.entity.TbArticle;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.service.TbArticleService;
import com.lyh.zone.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：zone
 * 类名称：ArticleController
 * 类描述：
 */
@Controller
@RequestMapping("/admin/article")
public class ArticleController extends BaseController {

    @Autowired
    private TbArticleService articleService;

    @Autowired
    private TbUserService userService;

    /**
     * 显示所有文章
     * @param modelAndView
     * @param page
     * @param limit
     * @param state
     * @param response
     * @param request
     * @return
     */
    @GetMapping
    public ModelAndView article(ModelAndView modelAndView, @RequestParam(value = "page",defaultValue = "1") int page,
                          @RequestParam(value = "limit",defaultValue = "10") int limit,
                          @RequestParam(value = "state",defaultValue = "0") Integer state,
                          HttpServletResponse response, HttpServletRequest request){
        TbArticle article=new TbArticle();
        article.setStatus(state);
        article.setPost(PostType.POST_TYPE_POST.getValue());
        TbUser user= WebUtil.currentUser(request,response);
        modelAndView.addObject("user",userService.selectById(user));
        PageInfo<TbArticle> pageInfo=articleService.findPageArticleSelf(page,limit,article,user);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("articles",pageInfo.getList());
        //已发布条数
        modelAndView.addObject("published",articleService.countByStatusSelf(ArticleStatus.PUBLISH.getStatus(),PostType.POST_TYPE_POST.getValue(),user));
        //草稿条数
        modelAndView.addObject("draft",articleService.countByStatusSelf(ArticleStatus.DRAFT.getStatus(),PostType.POST_TYPE_POST.getValue(),user));
        //回收站条数
        modelAndView.addObject("recycle",articleService.countByStatusSelf(ArticleStatus.RECYCLE.getStatus(),PostType.POST_TYPE_POST.getValue(),user));
        modelAndView.addObject("articleStatus",state);
        modelAndView.setViewName("admin/admin_article");
        return modelAndView;
    }

    /**
     * 过滤空格
     * @param articleTitle
     * @return
     */
    @PostMapping("/filter")
    @ResponseBody
    public JsonResult filter(String articleTitle){
        articleTitle=articleTitle.replaceAll(" ","-");
        return new JsonResult(true,articleTitle);
    }

    /**
     * 新建文章页面
     * @param modelAndView
     * @param response
     * @param request
     * @return
     */
    @GetMapping("/new")
    public ModelAndView save(ModelAndView modelAndView,HttpServletResponse response,HttpServletRequest request){
        TbUser user=WebUtil.currentUser(request,response);
        modelAndView.addObject("user",userService.selectById(user));
        modelAndView.setViewName("/admin/admin_new_article");
        return modelAndView;
    }

    /**
     * 保存文章
     * @param article
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/new/save")
    @ResponseBody
    public JsonResult save(TbArticle article,HttpServletRequest request,HttpServletResponse response){
        try {
            if (StrUtil.isEmpty(article.getTitle())) {
                return new JsonResult(false, "标题不能为空");
            }
            if (article.getId() == null) {
                // 判断文章链接是否重复
                if (!StrUtil.isEmpty(article.getUrl())) {
                    if(article.getUrl().length()>50) {
                        return new JsonResult(false, "路径不能大于50");
                    }
                    // 查询url是否重复
                    int repeat = articleService.findRepeatByUrl(article.getUrl());
                    if (repeat != 0) {
                        return new JsonResult(false, "路径已存在");
                    }
                }
                TbUser user=WebUtil.currentUser(request,response);
                article.setUid(user.getId());
                article.setNewstime(DateUtil.date());
                article.setUpdatetime(DateUtil.date());
                // 如果自定义链接为空则按时间戳生成链接
                if (StrUtil.isEmpty(article.getUrl())) {
                    article.setUrl(String.valueOf(System.currentTimeMillis() / 1000));
                }
                // 如果没有选择略缩图则随机一张图
                if (StrUtil.isEmpty(article.getThumbnail())) {
                    article.setThumbnail("/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
                }
                // 判断摘要是否为空
                if (StrUtil.isEmpty(article.getSummary())) {
                    // 如果摘要为空则取前五十字为摘要
                    int post_summary = 50;
                    // 清理html标签和空白字符
                    String summaryText = StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(article.getContent()));
                    // 设置文章摘要
                    if (summaryText.length() > post_summary) {
                        article.setSummary(summaryText.substring(0, post_summary));
                    } else {
                        article.setSummary(summaryText);
                    }
                }
                ArticleDTO articleDTO=new ArticleDTO(article.getUid(),article.getContent(),article.getContentMd(),
                        article.getNewstime(),article.getStatus(),article.getSummary(),article.getThumbnail(),
                        article.getTitle(),article.getType(),article.getPost(),article.getComment(),
                        article.getUpdatetime(),article.getUrl(),article.getViews());
                articleService.save(articleDTO);
            } else {
                // 如果没有选择略缩图则随机一张图
                if (StrUtil.isEmpty(article.getThumbnail())) {
                    article.setThumbnail("/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
                }
                // 判断摘要是否为空
                if (StrUtil.isEmpty(article.getSummary())) {
                    // 如果摘要为空则取前五十字为摘要
                    int post_summary = 50;
                    // 清理html标签和空白字符
                    String summaryText = StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(article.getContent()));
                    // 设置文章摘要
                    if (summaryText.length() > post_summary) {
                        article.setSummary(summaryText.substring(0, post_summary));
                    } else {
                        article.setSummary(summaryText);
                    }
                }
                // 文章最后修改时间
                article.setUpdatetime(DateUtil.date());
                articleService.updateById(article);
            }
        } catch (Exception e) {
            log.error("添加或更新失败" + e.getMessage());
            return new JsonResult(MaydayEnums.ERROR.isFlag(), MaydayEnums.ERROR.getMessage());
        }
        return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
    }

    /**
     * 还原文章为发布状态
     * @param id
     * @return
     */
    @PostMapping(value = "/restore")
    @ResponseBody
    public JsonResult restore(@RequestParam(value = "id") int id){
        try{
            TbArticle article=new TbArticle();
            article.setId(id);
            article.setStatus(ArticleStatus.PUBLISH.getStatus());
            articleService.updateById(article);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return new JsonResult(MaydayEnums.OPERATION_SUCCESS.isFlag(),MaydayEnums.OPERATION_SUCCESS.getMessage());
    }

    /**
     * 修改文章状态为回收站
     * @param id
     * @return
     */
    @GetMapping("/recycle")
    public ModelAndView updateStatus(@RequestParam(value = "id") int id,ModelAndView modelAndView){
        try{
            TbArticle article=new TbArticle();
            article.setId(id);
            article.setStatus(ArticleStatus.RECYCLE.getStatus());
            articleService.updateById(article);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        modelAndView.setViewName("redirect:/admin/article?state=0");
        return modelAndView;
    }

    /**
     * 彻底删除文章
     * @param id
     * @param modelAndView
     * @return
     */
    @GetMapping("/remove")
    public ModelAndView remove(@RequestParam(value = "id") int id,ModelAndView modelAndView){
        try{
            TbArticle article=new TbArticle();
            article.setId(id);
            articleService.deleteById(article);
        } catch (Exception e){
            log.error("删除文章失败"+e.getMessage());
        }
        modelAndView.setViewName("redirect:/admin/article?state=2");
        return modelAndView;
    }

    /**
     * 修改文章页面
     * @param modelAndView
     * @param article_id
     * @return
     */
    @GetMapping("/edit")
    public ModelAndView editArticle(ModelAndView modelAndView,@RequestParam(value = "article_id") Integer article_id,
                                    HttpServletResponse response,HttpServletRequest request){
        try{
            TbArticle tbArticle=new TbArticle();
            tbArticle.setId(article_id);
            TbArticle article=articleService.selectById(tbArticle);
            modelAndView.addObject("articleCustom",article);
            TbUser user=WebUtil.currentUser(request,response);
            modelAndView.addObject("user",userService.selectById(user));
        } catch (Exception e){
            log.error(e.getMessage());
        }
        modelAndView.setViewName("admin/admin_edit_article");
        return modelAndView;
    }
}
