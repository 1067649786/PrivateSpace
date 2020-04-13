package com.lyh.zone.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lyh.zone.entity.TbRelation;
import com.lyh.zone.mapper.TbRelationMapper;
import com.lyh.zone.service.TbRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbRelationServiceImpl
 * 类描述：
 */
@Service
public class TbRelationServiceImpl extends ServiceImpl<TbRelationMapper, TbRelation> implements TbRelationService {

    @Autowired
    private TbRelationMapper relationMapper;

    @Override
    public List<TbRelation> selectRelation() {
        return relationMapper.selectRelation();
    }
}
