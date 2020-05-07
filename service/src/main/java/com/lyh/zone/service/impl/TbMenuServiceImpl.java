package com.lyh.zone.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lyh.zone.dto.MenuDTO;
import com.lyh.zone.entity.TbMenu;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.mapper.TbMenuMapper;
import com.lyh.zone.service.TbMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbMenuServiceImpl
 * 类描述：
 */
@Service
public class TbMenuServiceImpl extends ServiceImpl<TbMenuMapper, TbMenu> implements TbMenuService {

    @Autowired
    private TbMenuMapper menuMapper;

    @Override
    public List<TbMenu> findMenus() {
        return menuMapper.findAllMenus();
    }

    @Override
    public List<TbMenu> findMenusByUid(TbUser user) {
        return menuMapper.findMenusByUid(user);
    }

    @Override
    public void save(MenuDTO menuDTO) {
        menuMapper.insetMenu(menuDTO);
    }
}
