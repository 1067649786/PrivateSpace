package com.lyh.zone.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.common.base.JsonResult;
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
 * 类名称：PageController
 * 类描述：
 */
@Controller
@RequestMapping("/admin/page")
public class PageController extends BaseController {

    @Autowired
    private TbArticleService articleService;

    @Autowired
    private TbUserService userService;

    /**
     * 显示所有页面
     * @param modelAndView
     * @param page
     * @param limit
     * @param state
     * @return
     */
    @GetMapping
    public ModelAndView page(ModelAndView modelAndView, @RequestParam(value = "page",defaultValue = "1") int page,
                             @RequestParam(value = "limit", defaultValue = "10") int limit,
                             @RequestParam(value = "state", defaultValue = "0") int state,
                             HttpServletResponse response, HttpServletRequest request){
        TbArticle article=new TbArticle();
        article.setStatus(state);
        article.setPost(PostType.POST_TYPE_PAGE.getValue());
        TbUser user= WebUtil.currentUser(request,response);
        PageInfo<TbArticle> pageInfo=articleService.findPageArticleSelf(page,limit,article,user);
        modelAndView.addObject("user",userService.selectById(user));
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("articles",pageInfo.getList());
        //已发布数
        modelAndView.addObject("published",articleService.countByStatusSelf(0,PostType.POST_TYPE_PAGE.getValue(),user));
        //草稿条数
        modelAndView.addObject("draft",articleService.countByStatusSelf(1,PostType.POST_TYPE_PAGE.getValue(),user));
        modelAndView.addObject("state",state);
        modelAndView.setViewName("admin/admin_page");
        return modelAndView;
    }

    /**
     * 新建页面
     * @param modelAndView
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/new")
    public ModelAndView newPage(ModelAndView modelAndView,HttpServletRequest request,HttpServletResponse response){
        modelAndView.addObject("user",userService.selectById(WebUtil.currentUser(request,response)));
        modelAndView.setViewName("admin/admin_new_page");
        return modelAndView;
    }

    /**
     * 保存页面
     * @param article
     * @param response
     * @param request
     * @return
     */
    @PostMapping("/new/save")
    @ResponseBody
    public JsonResult save(TbArticle article,HttpServletResponse response,HttpServletRequest request){
        try {
            if (StrUtil.isEmpty(article.getTitle())) {
                return new JsonResult(false, "标题不能为空");
            }
            if (article.getId() == null) {
                // 判断文章链接是否重复
                if (!StrUtil.isEmpty(article.getUrl())) {
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
                //article.setUrl("/user/"+article.getUrl());
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
                // 页面最后修改时间
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
     * 彻底删除页面
     * @param id
     * @return
     */
    @GetMapping("/remove")
    public ModelAndView remove(@RequestParam(value = "id") int id,ModelAndView modelAndView){
        try{
            TbArticle article=new TbArticle();
            article.setId(id);
            articleService.deleteById(article);
        } catch (Exception e){
            log.error("删除文章失败" + e.getMessage());
        }
        modelAndView.setViewName("redirect:/admin/page?state=0");
        return modelAndView;
    }

    /**
     * 修改页面
     * @param modelAndView
     * @param article_id
     * @return
     */
    @GetMapping("/edit")
    public ModelAndView editArticle(ModelAndView modelAndView,@RequestParam(value = "article_id") Integer article_id,
                                    HttpServletRequest request,HttpServletResponse response){
        try{
            TbArticle tbArticle=new TbArticle();
            tbArticle.setId(article_id);
            TbArticle article=articleService.selectById(tbArticle);
            modelAndView.addObject("articleCustom",article);
            modelAndView.addObject("user",userService.selectById(WebUtil.currentUser(request,response)));
        } catch (Exception e){
            log.error(e.getMessage());
        }
        modelAndView.setViewName("admin/admin_edit_page");
        return modelAndView;
    }
}
