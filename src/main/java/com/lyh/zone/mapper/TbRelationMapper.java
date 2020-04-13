package com.lyh.zone.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lyh.zone.entity.TbRelation;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbRelationMapper
 * 类描述：
 */
public interface TbRelationMapper extends BaseMapper<TbRelation> {

    List<TbRelation> selectRelation();
}
