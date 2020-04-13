package com.lyh.zone.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.common.constant.CommonConstant;
import com.lyh.zone.common.enums.ArticleStatus;
import com.lyh.zone.common.enums.PostType;
import com.lyh.zone.common.enums.ResultEnum;
import com.lyh.zone.common.utils.Commons;
import com.lyh.zone.common.utils.CookieUtil;
import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.dto.ArchiveBo;
import com.lyh.zone.entity.*;
import com.lyh.zone.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 项目名称：zone
 * 类名称：UserController
 * 类描述：
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private TbUserService userService;

    @Autowired
    private TbRelationService relationService;

    @Autowired
    private TbBindService bindService;

    @Autowired
    private TbArticleService articleService;

    @Autowired
    private TbMenuService menuService;

    @Autowired
    private Commons commons;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @PostMapping("/login")
    public ModelAndView doLogin(HttpServletRequest request, TbUser user,
                                HttpServletResponse response, String remember,
                                ModelAndView modelAndView, String verifyCode) {
        logger.info("login:登陆用户详情：{}", user.toString());
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            //result.setResult(ResultEnum.PARAM_NULL);
            modelAndView.addObject("error", ResultEnum.PARAM_NULL.getMsg());
            modelAndView.setViewName("user/login");
            return modelAndView;
        }
        if (StringUtils.isNotEmpty(verifyCode) && !verifyCode.equals(request.getSession().getAttribute("code"))) {
            //result.setResult(ResultEnum.VERIFY_CODE_NOT_CORRECT);
            modelAndView.addObject("error", ResultEnum.VERIFY_CODE_NOT_CORRECT.getMsg());
            modelAndView.setViewName("user/login");
            return modelAndView;
        }

        TbUser userDB = userService.login(user.getUsername(), user.getPassword());
        if (userDB != null) {
            WebUtil.loginUser(request, response, userDB, "on".equals(remember));
            modelAndView.addObject("user", userDB);
            modelAndView.setViewName("redirect:/user/index");
        } else {
            //result.setResult(ResultEnum.USERNAME_OR_PASSWORD_ERROR);
            modelAndView.addObject("error", ResultEnum.USERNAME_OR_PASSWORD_ERROR.getMsg());
            modelAndView.setViewName("user/login");
            logger.info("用户未查到");
        }
        return modelAndView;
    }

    /**
     * 请求首页
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        return this.index(modelAndView, 1, response, request);
    }

    @GetMapping(value = "page/{page}")
    public ModelAndView index(ModelAndView modelAndView, @PathVariable(value = "page") Integer page,
                              HttpServletResponse response, HttpServletRequest request) {
        page = page < 0 || page > CommonConstant.MAX_PAGE ? 1 : page;
        //默认显示条数
        Integer limit = CommonConstant.POST_INDEX_LIMIT;

        TbUser user = WebUtil.currentUser(request, response);
        TbArticle article = new TbArticle();
        article.setStatus(ArticleStatus.PUBLISH.getStatus());
        article.setPost(PostType.POST_TYPE_POST.getValue());
        PageInfo<TbArticle> pageInfo = articleService.findPageArticle(page, limit, article, user);
        //model.addAttribute("articles",pageInfo);
        List<TbArticle> articles = pageInfo.getList();
        List<TbMenu> menus = menuService.findMenusByUid(user);
        modelAndView.addObject("articles", articles);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("themes/pinghsu/index");
        modelAndView.addObject("menus", menus);
        modelAndView.addObject("commons", commons);
        return modelAndView;
        //return this.render("index");
    }

    /**
     * 归档
     *
     * @param modelAndView
     * @return
     */
    @GetMapping("/archives")
    public ModelAndView archives(ModelAndView modelAndView, HttpServletResponse response, HttpServletRequest request) {
        TbUser user = WebUtil.currentUser(request, response);
        List<ArchiveBo> archiveBos = articleService.archives(user);
        //List<TbMenu> menus = menuService.findMenus();
        List<TbMenu> menus = menuService.findMenusByUid(user);
        modelAndView.addObject("menus", menus);
        modelAndView.addObject("commons", commons);
        modelAndView.addObject("articleList", archiveBos);
        modelAndView.setViewName("themes/pinghsu/archives");
        return modelAndView;
    }

    /**
     * 日记详情
     *
     * @param modelAndView
     * @param articleUrl
     * @return
     */
    @GetMapping("/post/{articleUrl}")
    public ModelAndView post(ModelAndView modelAndView, @PathVariable(value = "articleUrl") String articleUrl,
                             HttpServletRequest request,HttpServletResponse response) {
        TbArticle article = articleService.findByArticleUrl(articleUrl);
        if (article == null) {
            modelAndView.setViewName("error/404");
        }
        List<TbMenu> menus = menuService.findMenusByUid(WebUtil.currentUser(request,response));
        modelAndView.addObject("menus", menus);
        modelAndView.addObject("commons", commons);
        modelAndView.addObject("article", article);
        modelAndView.setViewName("themes/pinghsu/post");
        return modelAndView;
    }

    @GetMapping("search/{keywords}")
    public ModelAndView search(ModelAndView modelAndView,
                               @PathVariable String keywords,
                               HttpServletRequest request,
                               HttpServletResponse response){
        return this.search(modelAndView,keywords,1,response,request);
    }

    @GetMapping("search/{keywords}/{page}")
    public ModelAndView search(ModelAndView modelAndView,@PathVariable String keywords,
                               @PathVariable Integer page,HttpServletResponse response,
                               HttpServletRequest request){
        Integer limit=CommonConstant.POST_INDEX_LIMIT;
        page=page<0 || page>CommonConstant.MAX_PAGE ? 1:page;
        TbUser user=WebUtil.currentUser(request,response);
        PageInfo<TbArticle> info=articleService.findArticleByKeywords(keywords,page,limit,user);
        List<TbMenu> menus = menuService.findMenusByUid(user);
        modelAndView.addObject("pageinfo",info);
        modelAndView.addObject("articles",info.getList());
        modelAndView.addObject("type","搜索");
        modelAndView.addObject("keywords",keywords);
        modelAndView.addObject("url","/user/search/"+keywords);
        modelAndView.addObject("menus",menus);
        modelAndView.addObject("commons",commons);
        modelAndView.setViewName("themes/pinghsu/page-category");
        return modelAndView;
    }

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

    @GetMapping("logout")
    public String logout(HttpServletResponse response) {
        CookieUtil.removeCookie(response, CommonConstant.USER_ID_COOKIE);
        return "redirect:/user/login";
    }

    @GetMapping("register")
    public String register() {
        return "user/register";
    }

    @PostMapping("register")
    public ModelAndView registerDo(HttpServletRequest request, TbUser user,
                                   HttpServletResponse response, String verifyCode,
                                   ModelAndView modelAndView) {
        logger.info("registerDo:用户详情：{}", user.toString());
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            //result.setResult(ResultEnum.PARAM_NULL);
            modelAndView.addObject("error", ResultEnum.PARAM_NULL.getMsg());
            modelAndView.setViewName("user/register");
            return modelAndView;
        }
        //TODO 添加邮箱手机校验

        if (user.getPassword().length() < 6 || user.getPassword().length() > 20) {
            //result.setResult(ResultEnum.PASSWORD_LENGTH_ERROR);
            modelAndView.addObject("error", ResultEnum.PASSWORD_LENGTH_ERROR.getMsg());
            modelAndView.setViewName("user/register");
            return modelAndView;
        }
        if ("123456".equals(user.getPassword())) {
            //result.setResult(ResultEnum.PASSWORD_TOO_SIMPLE);
            modelAndView.addObject("error", ResultEnum.PASSWORD_TOO_SIMPLE.getMsg());
            modelAndView.setViewName("user/register");
            return modelAndView;
        }
        if (StringUtils.isNotEmpty(verifyCode) && !verifyCode.equals(request.getSession().getAttribute("code"))) {
            //result.setResult(ResultEnum.VERIFY_CODE_NOT_CORRECT);
            modelAndView.addObject("error", ResultEnum.VERIFY_CODE_NOT_CORRECT.getMsg());
            modelAndView.setViewName("user/register");
            return modelAndView;
        }
        if (userService.selectByUsername(user.getUsername()) != null) {
            //result.setResult(ResultEnum.USERNAME_EXIST);
            modelAndView.addObject("error", ResultEnum.USERNAME_EXIST.getMsg());
            modelAndView.setViewName("user/register");
            return modelAndView;
        }
        user.setRealname(user.getUsername());
        user.setIcon("/img/portrait.jpg");
        userService.register(user);
        WebUtil.loginUser(request, response, user, true);
        modelAndView.addObject("user", user);
        List<TbRelation> relations = relationService.selectRelation();
        logger.info(relations.toString());
        modelAndView.addObject("relations", relations);
        modelAndView.setViewName("user/bind");
        return modelAndView;
    }

    /**
     * 关系绑定
     * @return
     */
    @GetMapping("/bind")
    public String bind() {
        return "user/bind";
    }

    @PostMapping("/bind")
    public ModelAndView bind(String bindCode, ModelAndView modelAndView, String relationId,
                             HttpServletResponse response, HttpServletRequest request) {
        TbUser user1 = userService.selectById(WebUtil.currentUser(request, response));
        TbUser user2 = userService.selectByBindCode(bindCode);
        if (user2 == null) {
            modelAndView.addObject("error", ResultEnum.BIND_CODE_ERROR.getMsg());
            modelAndView.setViewName("user/bind");
            return modelAndView;
        }
        logger.info(relationId);
        TbBind bind = new TbBind();
        bind.setUid1(user1.getId());
        bind.setUid2(user2.getId());
        bind.setRelationid(Integer.parseInt(relationId));
        bind.setDate(new Date());
        bindService.insert(bind);
        user1.setIsBind(1);
        user2.setIsBind(1);
        userService.updateById(user1);
        userService.updateById(user2);
        modelAndView.addObject("currentUser", user1);
        modelAndView.addObject("bindUser", user2);
        modelAndView.setViewName("redirect:/user/index");
        return modelAndView;
    }

    /**
     * 验证码
     *
     * @param request
     * @param response
     */
    @GetMapping("captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 50);
            lineCaptcha.createCode();
            request.getSession().setAttribute("code", lineCaptcha.getCode());
            ImageIO.write(lineCaptcha.getImage(), "JPEG", response.getOutputStream());
        } catch (IOException e) {
            logger.error("获取验证码出错", e);
        }
    }

}
