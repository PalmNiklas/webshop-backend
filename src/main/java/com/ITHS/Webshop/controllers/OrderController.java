package com.ITHS.Webshop.controllers;


import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.OrderItem;
import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.OrderRepository;
import com.ITHS.Webshop.repositories.OrderStatusRepository;
import com.ITHS.Webshop.services.OrderService;
import com.ITHS.Webshop.services.OrderServiceImpl;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @GetMapping
    public List<Order> list() {
    return orderService.getAllOrders();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Order get(@PathVariable int id) {

      return  orderService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody final Order order) {
        return orderService.create(order);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Order update(@PathVariable int id, @RequestBody Order order) {
     return orderService.update(id, order);
    }

    @CrossOrigin
    @RequestMapping(value = "addItem/{orderId}", method = RequestMethod.PUT)
    public Order addItemToOrder(@PathVariable int orderId, @RequestBody OrderItem item) {
        return orderService.addOrderItem(orderId, item);
    }

    @GetMapping
    @RequestMapping(value = "activeOrder/{userId}", method = RequestMethod.GET)
    public Order getActiveOrder(@PathVariable int userId) {
        return orderService.getCurrentOrder(userId);
    }

}
