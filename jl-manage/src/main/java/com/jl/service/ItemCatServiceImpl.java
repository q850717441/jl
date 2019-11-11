package com.jl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jl.anno.CacheFind;
import com.jl.mapper.ItemCatMapper;
import com.jl.pojo.ItemCat;
import com.jl.util.ObjectMapperUtil;
import com.jl.vo.EasyUITree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired()
    private ItemCatMapper itemCatMapper;
    @Autowired
    private JedisCluster jedis;

    @Override
    public ItemCat findItemCatById(Long itemCatId) {

        return itemCatMapper.selectById(itemCatId);
    }


    /**
     * 1.根据parentId查询数据库记录
     * 2.循环遍历数据,之后封装EasyUITree的list集合
     */
    @Override
    @CacheFind
    public List<EasyUITree> findItemCatByParentId(Long parentId) {
        //1.查询数据
        List<ItemCat> itemCatList =
                findItemCatListByParentId(parentId);
        //2.实现数据封装
        List<EasyUITree> treeList =
                new ArrayList<EasyUITree>(itemCatList.size());
        for (ItemCat itemCat : itemCatList) {
            Long id = itemCat.getId();
            String text = itemCat.getName();
            //如果是父级 closed,否则 表示3级标题 open
            String state = itemCat.getIsParent() ? "closed" : "open";
            EasyUITree tree = new EasyUITree(id, text, state);
            treeList.add(tree);
        }

        return treeList;
    }

    private List<ItemCat> findItemCatListByParentId(Long parentId) {
        QueryWrapper<ItemCat> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", parentId);
        List<ItemCat> itemCatList =
                itemCatMapper.selectList(queryWrapper);
        return itemCatList;
    }

    /**
     * 步骤:
     * 1.先查询缓存  确定key的写法
     * 2.如果缓存中没有数据.说明用户第一次查询.
     * 先查询数据库,将数据转化为JSON.保存到redis中.
     * 3.如果缓存中有数据.说明不是第一次查询.从redis中
     * 获取数据.需要将json转化为对象.
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<EasyUITree> findItemCatCache(Long parentId) {

        List<EasyUITree> treeList = new ArrayList<>();
        String key = "ITEMCAT::" + parentId;
        String json = jedis.get(key);
        //判断数据是否为null
        if (StringUtils.isEmpty(json)) {
            //用户第一次查询
            treeList = findItemCatByParentId(parentId);
            String itemCatJSON = ObjectMapperUtil.toJSON(treeList);
            jedis.set(key, itemCatJSON);
            System.out.println("用户第一次查询数据");
        } else {
            //说明用户不是第一次查询
            treeList = ObjectMapperUtil.toObject(json, treeList.getClass());
            System.out.println("用户查询缓存!!!!");
        }

        return treeList;
    }

}
