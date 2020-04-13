package com.lyh.zone.controller.admin;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.common.enums.ArticleStatus;
import com.lyh.zone.common.enums.PostType;
import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.controller.BaseController;
import com.lyh.zone.entity.TbArticle;
import com.lyh.zone.entity.TbBind;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.service.TbArticleService;
import com.lyh.zone.service.TbAttachmentService;
import com.lyh.zone.service.TbBindService;
import com.lyh.zone.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 项目名称：zone
 * 类名称：AdminController
 * 类描述：
 */
@RequestMapping("/admin")
@Controller
public class AdminController extends BaseController {

    @Autowired
    private TbArticleService articleService;

    @Autowired
    private TbAttachmentService attachmentService;

    @Autowired
    private TbBindService bindService;

    @Autowired
    private TbUserService userService;

    /**
     * 后台首页
     * @param modelAndView
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = {"","index"})
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request,
                              HttpServletResponse response){

        TbUser user= WebUtil.currentUser(request,response);
        TbUser tbUser=userService.selectById(user);
        modelAndView.addObject("user",tbUser);
        //查询已发布总文章数
        Integer contPublishAll=articleService.countByStatusAll(0, PostType.POST_TYPE_POST.getValue(),user);
        modelAndView.addObject("countPublishAll",contPublishAll);
        //查询自己已发布文章数
        Integer countPublishSelf=articleService.countByStatusSelf(0,PostType.POST_TYPE_POST.getValue(),user);
        modelAndView.addObject("countPublishSelf",countPublishSelf);
        //照片总数
        int countAttachment=attachmentService.countAttachment(user).size();
        modelAndView.addObject("countAttachment",countAttachment);
        //关系绑定天数
        TbBind bind =bindService.selectBindByUser(user);
        String date=DateUtil.format(bind.getDate(),"yyyy-MM-dd HH:mm:ss");
        Date start= DateUtil.parse(date);
        modelAndView.addObject("establishDate",DateUtil.between(start,DateUtil.date(), DateUnit.DAY));
        //查询最新的文章
        TbArticle article=new TbArticle();
        article.setPost(PostType.POST_TYPE_POST.getValue());
        article.setStatus(ArticleStatus.PUBLISH.getStatus());
        PageInfo<TbArticle> pageInfo=articleService.findPageArticle(1,5,article,user);
        modelAndView.addObject("articles",pageInfo.getList());
        modelAndView.setViewName("admin/admin_index");
        return modelAndView;
    }
}
