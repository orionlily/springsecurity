package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/4/16
 */
@TableName("user")
@Data
@Alias("SysUser")
public class SysUser {

    private Integer id;

    private String name;

    private String account;

    private String password;

    private String email;

    private String tel;

    private List<SysRole> roles;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birthday;
}
