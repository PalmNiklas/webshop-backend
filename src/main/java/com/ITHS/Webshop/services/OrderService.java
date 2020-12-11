package com.ITHS.Webshop.services;


import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.OrderItem;
import com.ITHS.Webshop.models.OrderStatus;

import java.util.List;

public interface OrderService {

    public List<Order> getAllOrders();
    public  Order getById(int id);
    public  Order create(Order order);
    public  Order update(int id, Order order);

    public Order getCurrentOrder(int userId);
    public Order addOrderItem(int orderId, OrderItem item);
    public List<OrderItem> getAllOrderItem(int orderId);
    public Order deleteOrderItem(int orderItemId);
    public OrderItem updateOrderItem(int OrderItemId);
    public OrderItem getOrderItem(int OrderItemId);

    public OrderStatus getOrderStatus(int OrderId);
}
