package com.jl.service;

import com.jl.anno.CacheFind;
import com.jl.pojo.Item;
import com.jl.pojo.ItemDesc;
import com.jl.util.HttpClientService;
import com.jl.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 08:42
 * @description:
 **/
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private HttpClientService httpClient;

    @Override
    @CacheFind
    public Item findItemById(Long itemId) {
        //连接jl-manage中服务
        String url = "http://manage.jl.com/web/item/findItemById";
        Map<String, String> params = new HashMap<String, String>();
        params.put("itemId", itemId + "");
        String itemJson = httpClient.doGet(url, params);

        return ObjectMapperUtil.toObject(itemJson, Item.class);
    }

    @Override
    @CacheFind
    public ItemDesc findItemDescById(Long itemId) {
        //连接jl-manage中服务
        String url = "http://manage.jl.com/web/item/findItemDescById";
        Map<String, String> params = new HashMap<String, String>();
        params.put("itemId", itemId + "");
        String itemDescJSON = httpClient.doGet(url, params);
        return ObjectMapperUtil.toObject(itemDescJSON, ItemDesc.class);
    }

}
