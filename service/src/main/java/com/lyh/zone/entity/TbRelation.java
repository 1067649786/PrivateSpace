package com.lyh.zone.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 项目名称：zone
 * 类名称：TbRelation
 * 类描述：
 */
@TableName("tb_relation")
public class TbRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String relation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public String toString() {
        return "TbRelation{" +
                "id=" + id +
                ", relation='" + relation + '\'' +
                '}';
    }
}
