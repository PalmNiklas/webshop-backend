package com.ITHS.Webshop.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "status_id")
    private Integer statusId;

}
