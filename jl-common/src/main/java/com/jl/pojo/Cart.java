package com.jl.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-19 09:57
 * @description:
 **/
@TableName("tb_cart")
@Data
@Accessors(chain = true)
public class Cart extends BasePojo {
    @TableId
    private Long id;
    private Long userId;
    private Long itemId;
    private String itemTitle;
    private String itemImage;
    private Long itemPrice;
    private Integer num;
}
