package com.lyh.zone.controller.admin;

import com.lyh.zone.common.utils.WebUtil;
import com.lyh.zone.controller.BaseController;
import com.lyh.zone.dto.MenuDTO;
import com.lyh.zone.entity.TbMenu;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.service.TbMenuService;
import com.lyh.zone.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 项目名称：zone
 * 类名称：MenusController
 * 类描述：
 */
@RequestMapping("/admin/menus")
@Controller
public class MenusController extends BaseController {

    @Autowired
    private TbMenuService menuService;

    @Autowired
    private TbUserService userService;

    /**
     * 进入菜单
     * @param modelAndView
     * @param response
     * @param request
     * @return
     */
    @GetMapping
    public ModelAndView menus(ModelAndView modelAndView, HttpServletResponse response, HttpServletRequest request){
        TbUser user= WebUtil.currentUser(request,response);
        modelAndView.addObject("user",userService.selectById(user));
        modelAndView.addObject("menus",menuService.findMenusByUid(user));
        modelAndView.setViewName("admin/admin_menus");
        return modelAndView;
    }

    /**
     * 编辑页面
     * @param modelAndView
     * @param menuId
     * @return
     */
    @GetMapping("/edit")
    public ModelAndView edit(ModelAndView modelAndView,@RequestParam(value = "menuId") Integer menuId,
                             HttpServletRequest request,HttpServletResponse response){
        TbMenu tbMenu=new TbMenu();
        tbMenu.setId(menuId);
        TbMenu menu=menuService.selectById(tbMenu);
        List<TbMenu> menus=menuService.findMenusByUid(WebUtil.currentUser(request,response));
        TbUser user= WebUtil.currentUser(request,response);
        modelAndView.addObject("user",userService.selectById(user));
        modelAndView.addObject("menus",menus);
        modelAndView.addObject("menu",menu);
        modelAndView.setViewName("admin/admin_menus");
        return modelAndView;
    }

    /**
     * 保存或修改
     * @param menu
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(TbMenu menu,HttpServletResponse response,HttpServletRequest request,ModelAndView modelAndView){
        try {
            menu.setUid(WebUtil.currentUser(request,response).getId());
            menu.setMenuUrl("/user/"+menu.getMenuUrl());
            if (menu.getId() == null) {
                MenuDTO menuDTO=new MenuDTO(menu.getUid(),menu.getMenuIcon(),
                        menu.getMenuName(),menu.getMenuSort(),menu.getMenuTarget(),menu.getMenuUrl());
                menuService.save(menuDTO);
            } else {
                menuService.updateById(menu);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        modelAndView.setViewName("redirect:/admin/menus");
        return modelAndView;
    }

    @GetMapping("/remove")
    public ModelAndView remove(@RequestParam(value = "menuId") Integer menuId,ModelAndView modelAndView){
        try{
            menuService.deleteById(menuId);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        modelAndView.setViewName("redirect:/admin/menus");
        return modelAndView;
    }
}
