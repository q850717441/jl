package com.jl.service;

import com.jl.pojo.Cart;

import java.util.List;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-19 10:03
 * @description:
 **/
public interface DubboCartService {

    List<Cart> findCartListByUserId(Long userId);

    void updateCartNum(Cart cart);
}
