package com.jxd.smsnew.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("userlogin")
public class UserLogin {
    private int userId;
    private String username;
    private String password;
    private int role;
}