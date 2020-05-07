package com.lyh.zone.service;

import com.github.pagehelper.PageInfo;
import com.lyh.zone.dto.AttachmentDTO;
import com.lyh.zone.entity.TbAttachment;
import com.lyh.zone.entity.TbUser;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbAttachment
 * 类描述：
 */
public interface TbAttachmentService {

    /**
     * 所有附件
     * @return
     */
    List<TbAttachment> countAttachment(TbUser user);

    /**
     * 分页查询附件
     * @param page
     * @param limit
     * @return
     */
    PageInfo<TbAttachment> getAttachment(int page,int limit,TbUser user);

    /**
     * 保存附件
     * @param attachmentDTO
     * @throws Exception
     */
    void save(AttachmentDTO attachmentDTO) throws Exception;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    TbAttachment findById(int id);

    /**
     * 删除
     * @param id
     * @throws Exception
     */
    void deleteAttachment(int id) throws Exception;
}
