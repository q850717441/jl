package com.jl.service;

import com.jl.pojo.Order;

public interface DubboOrderService {

    String insertOrder(Order order);

    Order findOrderById(String id);

}
