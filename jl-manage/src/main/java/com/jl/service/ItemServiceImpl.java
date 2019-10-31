package com.jl.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jl.mapper.ItemMapper;
import com.jl.pojo.Item;
import com.jl.vo.EasyUITable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public EasyUITable findItemByPage(Integer page, Integer rows) {

        //int total = itemMapper.selectCount(null);
        //int start = (page - 1) * rows;
        //List<Item> userList =
        //itemMapper.findItemByPage(start,rows);

        Page<Item> tempPage = new Page<>(page, rows);
        QueryWrapper<Item> queryWrapper = new QueryWrapper<Item>();
        queryWrapper.orderByDesc("updated");
        //当前查询的分页结果对象
        IPage<Item> IPage =
                itemMapper.selectPage(tempPage, queryWrapper);
        //获取总记录数
        int total = (int) IPage.getTotal();
        //获取分页的结果
        List<Item> userList = IPage.getRecords();
        return new EasyUITable(total, userList);
    }

    @Override
    public void saveItem(Item item) {

        item.setStatus(1)    //表示正常状态
                .setCreated(new Date())
                .setUpdated(item.getCreated());
        itemMapper.insert(item);
    }


    @Override
    public void updateItem(Item item) {

        item.setUpdated(new Date());
        itemMapper.updateById(item);
        //所有数据都更新.
    }


    /**
     * 任务:将ids中所有的数据的状态status改为2
     */
    @Override
    public void updateStatus(Long[] ids, Integer status) {

        //1.小白级别
        /*
         * for (Long id : ids) {
         * Item item = new Item();
         * item.setId(id)
         * .setStatus(status) .setUpdated(new Date());
         * itemMapper.updateById(item);
         * }
         */

        //2.菜鸟级别  sql
        Item item = new Item();
        item.setStatus(status).setUpdated(new Date());
        UpdateWrapper<Item> updateWrapper = new UpdateWrapper<Item>();
        List idList = Arrays.asList(ids);
        updateWrapper.in("id", idList);
        itemMapper.update(item, updateWrapper);
    }

    @Override
    public void deleteItem(Long[] ids) {
        for (Long id : ids) {
            itemMapper.deleteById(id);
        }
    }
}
