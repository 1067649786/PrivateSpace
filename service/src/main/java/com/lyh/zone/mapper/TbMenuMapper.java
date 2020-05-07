package com.lyh.zone.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lyh.zone.dto.MenuDTO;
import com.lyh.zone.entity.TbMenu;
import com.lyh.zone.entity.TbUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbMenuMapper
 * 类描述：
 */
@Repository
public interface TbMenuMapper extends BaseMapper<TbMenu> {

    List<TbMenu> findAllMenus();

    List<TbMenu> findMenusByUid(@Param("user") TbUser user);

    int insetMenu(MenuDTO menuDTO);
}
