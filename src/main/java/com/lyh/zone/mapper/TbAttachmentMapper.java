package com.lyh.zone.mapper;

import com.lyh.zone.dto.AttachmentDTO;
import com.lyh.zone.entity.TbAttachment;
import com.lyh.zone.entity.TbUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 项目名称：zone
 * 类名称：TbAttachmentMapper
 * 类描述：
 */
public interface TbAttachmentMapper {

    List<TbAttachment> countAttachment(@Param("user") TbUser user);

    List<TbAttachment> getAttachment(@Param("user") TbUser user);

    int insertAttachment(AttachmentDTO attachmentDTO);

    TbAttachment selectById(Integer id);

    int deleteById(Integer id);
}
