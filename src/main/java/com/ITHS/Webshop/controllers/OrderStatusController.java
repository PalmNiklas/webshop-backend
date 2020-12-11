package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.OrderItem;
import com.ITHS.Webshop.models.OrderStatus;
import com.ITHS.Webshop.services.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-status")
public class OrderStatusController {

    @Autowired
    OrderStatusService statusService;

    @GetMapping
    public List<OrderStatus> list() {
        return statusService.getAllStatuses();
    }

    @GetMapping
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public OrderStatus get(@PathVariable int id) {
        return statusService.getById(id);
    }
}
