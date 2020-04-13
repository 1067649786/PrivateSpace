package com.lyh.zone.controller;

import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.entity.TbArticle;
import com.lyh.zone.entity.TbMenu;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.service.TbArticleService;
import com.lyh.zone.service.TbMenuService;
import com.lyh.zone.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 项目名称：zone
 * 类名称：IndexController
 * 类描述：
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private TbArticleService articleService;

    @Autowired
    private TbMenuService menuService;

    @Autowired
    private TbUserService userService;

    /**
     * 自建页面
     * @param articleUrl
     * @param modelAndView
     * @param request
     * @return
     */
    @GetMapping("/{articleUrl}")
    public ModelAndView page(@PathVariable String articleUrl, ModelAndView modelAndView,
                             HttpServletRequest request, HttpServletResponse response){
        TbArticle article=articleService.findByArticleUrl(articleUrl);
        if(article==null){
            modelAndView.setViewName(this.render_404());
            return modelAndView;
        }
        TbUser user= WebUtil.currentUser(request,response);
        List<TbMenu> menus = menuService.findMenusByUid(user);
        modelAndView.addObject("menus", menus);
        modelAndView.addObject("article",article);
        modelAndView.setViewName("themes/pinghsu/page");
        return modelAndView;
    }
}
