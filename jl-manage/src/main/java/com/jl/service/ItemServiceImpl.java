package com.jl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jl.mapper.ItemMapper;
import com.jl.pojo.Item;
import com.jl.vo.EasyUITable;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemMapper itemMapper;

	/*
	 * 1.查询商品总记录数
	 * 2.进行分页查询
	 *   
	 *   分页sql:  每页20条
	 *   第1页                                                    起始位置,展现条数
	 * 	 select * from tb_item limit 0,20 	 [0,19]
	 *   第2页
	 *   select * from tb_item limit 20,20 	 [20,39]
	 *   第3页
	 *   select * from tb_item limit 40,20 	 [40,59]
	 *    第N页
	 *   select * from tb_item order by updated limit (page-1)*rows,rows
	 *   
	 * mybatis-plus分页说明
	 * 1.new Page<>(current, size);
	 * 	 current:当前页数
	 * 	 size:   每页条数
	 */
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
}
