package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.OrderStatus;
import com.ITHS.Webshop.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{
     @Autowired
    OrderStatusRepository statusRepository;

    @Override
    public List<OrderStatus> getAllStatuses() {
      return statusRepository.findAll();
    }

    @Override
    public OrderStatus getById(int id) {
        return statusRepository.getOne(id);
    }
}
