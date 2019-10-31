package com.jl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-10-31 10:46
 * @description:
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUITree {
    private Long  id;     //节点ID
    private String text;    //文本信息
    private String state;   //状态

}
