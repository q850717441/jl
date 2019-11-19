package com.jl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jl.pojo.Cart;
import com.jl.service.DubboCartService;
import com.jl.vo.SysResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-19 10:22
 * @description:
 **/

//jt-web中购物车业务 消费者
@Controller
@RequestMapping("/cart")
public class CartController {
    @Reference(check = false) //提供者可以懒加载
    private DubboCartService cartService;

    /**
     * 查询购物车记录,在页面中展现数据
     * 页面取值:${cartList}
     *
     * @return
     */
    @RequestMapping("/show")
    public String show(Model model) {

        //1.获取当前用户信息 userId
        Long userId = 7L;
        //2.查询数据
        List<Cart> cartList = cartService.findCartListByUserId(userId);
        model.addAttribute("cartList", cartList);
        return "cart";
    }

    @RequestMapping("/update/num/{itemId}/{num}")
    @ResponseBody
    public SysResult updateNum(Cart cart) {
        Long userId = 7L;
        cart.setUserId(userId);
        cartService.updateCartNum(cart);
        return SysResult.success();
    }
}
