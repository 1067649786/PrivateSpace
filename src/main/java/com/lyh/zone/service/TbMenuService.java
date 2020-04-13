package com.lyh.zone.service;

import com.baomidou.mybatisplus.service.IService;
import com.lyh.zone.dto.MenuDTO;
import com.lyh.zone.entity.TbMenu;
import com.lyh.zone.entity.TbUser;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbMenuService
 * 类描述：
 */
public interface TbMenuService extends IService<TbMenu> {

    /**
     * 所有菜单
     * @return
     */
    List<TbMenu> findMenus();

    /**
     * 根据用户id查找菜单
     * @return
     */
    List<TbMenu> findMenusByUid(TbUser user);

    /**
     * 添加
     * @param menuDTO
     */
    void save(MenuDTO menuDTO);
}
