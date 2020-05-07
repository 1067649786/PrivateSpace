package com.lyh.zone.service;

import com.baomidou.mybatisplus.service.IService;
import com.lyh.zone.entity.TbRelation;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbRelationService
 * 类描述：
 */
public interface TbRelationService extends IService<TbRelation> {

    List<TbRelation> selectRelation();
}
