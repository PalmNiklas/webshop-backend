package com.ITHS.Webshop.repositories;

import com.ITHS.Webshop.models.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer>, JpaSpecificationExecutor<OrderStatus> {

}