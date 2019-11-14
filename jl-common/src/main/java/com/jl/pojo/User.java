package com.jl.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-11-14 09:02
 * @description:
 **/
@TableName("tb_user")
@Data
@Accessors(chain = true)
public class User extends BasePojo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private String phone;
    private String email;
}
