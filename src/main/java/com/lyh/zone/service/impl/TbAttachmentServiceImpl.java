package com.lyh.zone.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyh.zone.dto.AttachmentDTO;
import com.lyh.zone.entity.TbAttachment;
import com.lyh.zone.entity.TbUser;
import com.lyh.zone.mapper.TbAttachmentMapper;
import com.lyh.zone.service.TbAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbAttachmentServiceImpl
 * 类描述：
 */
@Service
public class TbAttachmentServiceImpl implements TbAttachmentService {

    @Autowired
    private TbAttachmentMapper attachmentMapper;

    @Override
    public List<TbAttachment> countAttachment(TbUser user) {
        return attachmentMapper.countAttachment(user);
    }

    @Override
    public PageInfo<TbAttachment> getAttachment(int page, int limit,TbUser user) {
        PageHelper.startPage(page, limit);
        List<TbAttachment> lists=attachmentMapper.getAttachment(user);
        return new PageInfo<>(lists);
    }

    @Override
    public void save(AttachmentDTO attachmentDTO) throws Exception {
        attachmentMapper.insertAttachment(attachmentDTO);
    }

    @Override
    public TbAttachment findById(int id) {
        return attachmentMapper.selectById(id);
    }

    @Override
    public void deleteAttachment(int id) throws Exception {
        attachmentMapper.deleteById(id);
    }
}
