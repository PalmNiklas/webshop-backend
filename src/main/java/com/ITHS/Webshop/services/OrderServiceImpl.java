package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.OrderItem;
import com.ITHS.Webshop.models.OrderStatus;
import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.OrderItemRepository;
import com.ITHS.Webshop.repositories.OrderRepository;
import com.ITHS.Webshop.repositories.OrderStatusRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserService userService;

    @Autowired
    OrderStatusRepository statusRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getById(int id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Order create(Order order) {
    if (order.getItems() == null){
        order.setItems(new HashSet<>());
    }

       return orderRepository.saveAndFlush(order);
    }

    @Override
    public Order update(int id, Order order) {

        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        Order existingOrder = orderRepository.getOne(id);
        BeanUtils.copyProperties(order, existingOrder, "id");
        return orderRepository.saveAndFlush(existingOrder);

    }

    @Override
    public Order addOrderItem(int orderId, OrderItem item) {
        Order existingOrder = getById(orderId);
        item.setOrder(existingOrder);
        orderItemRepository.save(item);
        existingOrder.getItems().add(item);
        return update(orderId, existingOrder);

    }

    @Override
    public Order getCurrentOrder(int userId) {
        User user = userService.getById(userId);
        Set<Order> orders = user.getOrders();
        Optional<Order> active = orders.stream().filter(x -> x.getStatus().getName().equals("Active")).findFirst();
        if(active.isPresent()){
            return active.get();
        } else {
            Order newOrder = new Order(user);
            newOrder.setStatus(statusRepository.getOne(1));
            return create(newOrder);
        }
    }

    @Override
    public List<OrderItem> getAllOrderItem(int orderId) {
        return null;
    }

    @Override
    public Order deleteOrderItem(int orderItemId) {
        return null;
    }

    @Override
    public OrderItem updateOrderItem(int OrderItemId) {
        return null;
    }

    @Override
    public OrderItem getOrderItem(int OrderItemId) {
        return null;
    }


    @Override
    public OrderStatus getOrderStatus(int OrderId) {
        return null;
    }
}
