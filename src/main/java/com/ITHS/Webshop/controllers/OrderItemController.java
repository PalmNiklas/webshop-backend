package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.Order;
import com.ITHS.Webshop.models.OrderItem;
import com.ITHS.Webshop.repositories.OrderItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-item")
public class OrderItemController {

    @Autowired
    OrderItemRepository orderItemRepository;

    @GetMapping
    public List<OrderItem> list() {
        return orderItemRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public OrderItem get(@PathVariable int id) {
        return orderItemRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItem create(@RequestBody final OrderItem orderItem) {
        return orderItemRepository.saveAndFlush(orderItem);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public OrderItem update(@PathVariable int id, @RequestBody OrderItem orderItem) {
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        OrderItem existingOrderItem = orderItemRepository.getOne(id);
        BeanUtils.copyProperties(orderItem, existingOrderItem, "id");
        return orderItemRepository.saveAndFlush(existingOrderItem);
    }
}
