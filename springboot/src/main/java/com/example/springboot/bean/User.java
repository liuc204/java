package com.example.springboot.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.internal.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

/**
 *
 */
@Data
@TableName("user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    @NotNull
    private String name;

    private Integer age;

    private String email;

    @TableField(value = "UUID", fill = FieldFill.INSERT)
    private String UUID;

    private String password;

//    @FieldEncrypt
    private String md5Password;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    public User() {
    }
}
