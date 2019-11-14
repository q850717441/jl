package com.jl.service;

import com.jl.pojo.Item;
import com.jl.pojo.ItemDesc;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 08:41
 * @description:
 **/
public interface ItemService {
    Item findItemById(Long itemId);

    ItemDesc findItemDescById(Long itemId);
}
