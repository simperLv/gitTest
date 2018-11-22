package com.lv.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: simperLv
 * DATE: 2018/11/14
 * TIME: 15:44
 *
 * @Description //TODO
 * github: https://github.com/simperLv
 */
@Entity
@Table(name = "good_types")
public class GoodTypeEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "tgt_id")
    private Long id;

    @Column(name = "tgt_name")
    private String name;

    @Column(name = "tgt_is_show")
    private int isShow;

    @Column(name = "tgt_order")
    private int order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "GoodTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isShow=" + isShow +
                ", order=" + order +
                '}';
    }
}
