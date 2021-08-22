package com.lanqiao.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@TableName("tb_user")
@Data
public class User {
    @TableId(value="user_id",type=IdType.AUTO)
    private Integer id;
    
    @TableField
    private String userName;

    private Integer userAge;
}