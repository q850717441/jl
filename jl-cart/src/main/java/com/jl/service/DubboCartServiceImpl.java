package com.jl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jl.mapper.CartMapper;
import com.jl.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-19 10:04
 * @description:
 **/
@Service  //注意 dubbo的注解
public class DubboCartServiceImpl implements DubboCartService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> findCartListByUserId(Long userId) {
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        return cartMapper.selectList(queryWrapper);
    }

    /**
     * sql:update tb_cart set num=#{num},updated=#{updated}
     * where user_id=#{userId}
     * and item_id = #{itemId}
     */

    @Override
    public void updateCartNum(Cart cart) {
        Cart cartTemp = new Cart();
        cartTemp.setNum(cart.getNum())
                .setUpdated(new Date());
        UpdateWrapper<Cart> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", cart.getUserId())
                .eq("item_id", cart.getItemId());
        cartMapper.update(cartTemp, updateWrapper);
    }
}
