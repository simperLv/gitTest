package com.lv.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * User: simperLv
 * DATE: 2018/11/14
 * TIME: 15:39
 *
 * @Description //TODO
 * github: https://github.com/simperLv
 */
@Entity
@Table(name = "good_infos")
public class GoodEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "tg_id")
    private Long id;

    @Column(name = "tg_title")
    private String title;

    @Column(name = "tg_price")
    private double price;

    @Column(name = "tg_unit")
    private String unit;

    @Column(name = "tg_order")
    private int order;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }



    @Override
    public String toString() {
        return "GoodEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", order=" + order +

                '}';
    }
}
