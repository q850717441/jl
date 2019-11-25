package com.jl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jl.pojo.Cart;
import com.jl.pojo.Order;
import com.jl.service.DubboCartService;
import com.jl.service.DubboOrderService;
import com.jl.util.UserThreadLocal;
import com.jl.vo.SysResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Reference(check = false)
    private DubboCartService cartService;

    @Reference(check = false)
    private DubboOrderService orderService;

    /**
     * 订单确认页,需要获取购物车记录. 通过userId. 页面获取数据:${carts}
     *
     * @return
     */
    @RequestMapping("/create")
    public String create(Model model) {
        Long userId = UserThreadLocal.getUser().getId();
        List<Cart> cartList = cartService.findCartListByUserId(userId);
        model.addAttribute("carts", cartList);
        return "order-cart";// 执行视图解析器方法
    }

    /**
     * 实现订单提交
     */
    @RequestMapping("/submit")
    @ResponseBody
    public SysResult insertOrder(Order order) {

        Long userId = UserThreadLocal.getUser().getId();
        order.setUserId(userId);
        String orderId = orderService.insertOrder(order);
        if (StringUtils.isEmpty(orderId)) {
            return SysResult.fail();
        }

        return SysResult.success(orderId);
    }

    /**
     * 根据orderId 查询数据库记录
     * 页面取值:${order.orderId}
     *
     * @param id
     * @return
     */
    @RequestMapping("/success")
    public String findOrderById(String id, Model model) {

        Order order = orderService.findOrderById(id);
        model.addAttribute("order", order);
        return "success";
    }


}
