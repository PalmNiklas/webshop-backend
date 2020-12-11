package com.ITHS.Webshop.services;


import com.ITHS.Webshop.models.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    public List<OrderStatus> getAllStatuses();
    public  OrderStatus getById(int id);
}
