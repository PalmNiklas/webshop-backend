package com.ITHS.Webshop.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_statuses")
public class OrderStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

}
