package com.hyj.projectlibrary2.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName()
public class User {
    private Integer userId;

    private String userName;

    private String userPwd;

    private String userEmail;
}
