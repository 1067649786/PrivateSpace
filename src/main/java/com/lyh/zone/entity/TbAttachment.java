package com.lyh.zone.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.util.Date;

/**
 * 项目名称：zone
 * 类名称：TbAttachment
 * 类描述：
 */
@TableName("tb_attachment")
public class TbAttachment {

    private Integer id;

    private Integer uid;

    private String pictureName;

    private String picturePath;

    private String pictureSmallPath;

    private String pictureType;

    private Date pictureCreateDate;

    private String pictureSize;

    private String pictureSuffix;

    private String pictureWH;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public String getPictureSmallPath() {
        return pictureSmallPath;
    }

    public void setPictureSmallPath(String pictureSmallPath) {
        this.pictureSmallPath = pictureSmallPath;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public Date getPictureCreateDate() {
        return pictureCreateDate;
    }

    public void setPictureCreateDate(Date pictureCreateDate) {
        this.pictureCreateDate = pictureCreateDate;
    }

    public String getPictureSize() {
        return pictureSize;
    }

    public void setPictureSize(String pictureSize) {
        this.pictureSize = pictureSize;
    }

    public String getPictureSuffix() {
        return pictureSuffix;
    }

    public void setPictureSuffix(String pictureSuffix) {
        this.pictureSuffix = pictureSuffix;
    }

    public String getPictureWH() {
        return pictureWH;
    }

    public void setPictureWH(String pictureWH) {
        this.pictureWH = pictureWH;
    }
}
