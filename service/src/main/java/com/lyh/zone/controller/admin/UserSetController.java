package com.lyh.zone.controller.admin;

import com.github.pagehelper.PageInfo;
import com.lyh.zone.common.base.JsonResult;
import com.lyh.zone.common.constant.CommonConstant;
import com.lyh.zone.common.enums.MaydayEnums;
import com.lyh.zone.common.utils.CookieUtil;
import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.controller.BaseController;
import com.lyh.zone.entity.TbAttachment;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.service.TbAttachmentService;
import com.lyh.zone.service.TbUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目名称：zone
 * 类名称：UserController
 * 类描述：
 */
@RequestMapping("/admin/profile")
@Controller
public class UserSetController extends BaseController {

    @Autowired
    private TbAttachmentService attachmentService;

    @Autowired
    private TbUserService userService;

    /**
     * 返回个人资料页面
     * @param modelAndView
     * @param request
     * @param response
     * @return
     */
    @GetMapping
    public ModelAndView profile(ModelAndView modelAndView,
                                HttpServletRequest request,HttpServletResponse response){
        TbUser user=userService.selectById(WebUtil.currentUser(request,response));
        modelAndView.addObject("user",user);
        modelAndView.setViewName("admin/admin_user");
        return modelAndView;
    }

    /**
     * 修改个人资料结果
     * @param user
     * @param response
     * @param request
     * @return
     */
    @PostMapping(value = "updateProfile")
    @ResponseBody
    public JsonResult updateProfile(TbUser user,HttpServletResponse response,HttpServletRequest request){
        try {
            user.setId(WebUtil.currentUser(request,response).getId());
            userService.updateById(user);
            CookieUtil.removeCookie(response, CommonConstant.USER_ID_COOKIE);
        } catch (Exception e){
            log.error("修改资料",e);
            return new JsonResult(MaydayEnums.ERROR.isFlag(),MaydayEnums.ERROR.getMessage());
        }
        return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(),MaydayEnums.PRESERVE_SUCCESS.getMessage());
    }

    /**
     * 修改密码
     * @param formerlyPwd
     * @param nowPwd
     * @param confirmPwd
     * @param userId
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/updatePwd")
    @ResponseBody
    public JsonResult updatePwd(@RequestParam(value = "formerlyPwd") String formerlyPwd,
                                @RequestParam(value = "nowPwd") String nowPwd,
                                @RequestParam(value = "confirmPwd") String confirmPwd,
                                @RequestParam(value = "userId") Integer userId,
                                HttpServletRequest request,HttpServletResponse response){
        if (StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(formerlyPwd) || StringUtils.isBlank(confirmPwd)) {
            return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(), "请填写完整信息");
        }
        if (!nowPwd.equals(confirmPwd)) {
            return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(), "两次密码不一样");
        }
        try {
            TbUser user = userService.findByUserIdAndUserPwd(userId,formerlyPwd);
            if (user != null) {
                user.setPassword(confirmPwd);
                userService.updateById(user);
                CookieUtil.removeCookie(response, CommonConstant.USER_ID_COOKIE);
            } else {
                return new JsonResult(MaydayEnums.OPERATION_ERROR.isFlag(), "原密码错误");
            }
        } catch (Exception e) {
            log.error("修改密码",e);
            return new JsonResult(MaydayEnums.ERROR.isFlag(), "修改密码失败");
        }
        return new JsonResult(MaydayEnums.OPERATION_SUCCESS.isFlag(), "修改密码成功");
    }

    /**
     * 所有附件
     * @param modelAndView
     * @param id
     * @param page
     * @param limit
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/openChoice/{id}")
    public ModelAndView openChoice(ModelAndView modelAndView, @PathVariable String id,
                                   @RequestParam(value = "page",defaultValue = "1") int page,
                                   @RequestParam(value = "limit",defaultValue = "18") int limit,
                                   HttpServletRequest request, HttpServletResponse response){
        TbUser user= WebUtil.currentUser(request,response);
        PageInfo<TbAttachment> lists=attachmentService.getAttachment(page,limit,user);
        modelAndView.addObject("info",lists.getList());
        modelAndView.addObject("pageInfo",lists);
        modelAndView.addObject("id",id);
        modelAndView.setViewName("admin/part/open_choice");
        return modelAndView;
    }
}
