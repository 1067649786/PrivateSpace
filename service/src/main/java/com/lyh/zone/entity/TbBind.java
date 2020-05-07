package com.lyh.zone.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 */
@TableName("tb_bind")
public class TbBind implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id= UUID.randomUUID().toString().replaceAll("-","");;

    private Integer uid1;

    private Integer uid2;

    private Integer relationid;

    private Date date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUid1() {
        return uid1;
    }

    public void setUid1(Integer uid1) {
        this.uid1 = uid1;
    }

    public Integer getUid2() {
        return uid2;
    }

    public void setUid2(Integer uid2) {
        this.uid2 = uid2;
    }

    public Integer getRelationid() {
        return relationid;
    }

    public void setRelationid(Integer relationid) {
        this.relationid = relationid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TbBind{" +
                "id='" + id + '\'' +
                ", uid1=" + uid1 +
                ", uid2=" + uid2 +
                ", relationid=" + relationid +
                ", date=" + date +
                '}';
    }
}
