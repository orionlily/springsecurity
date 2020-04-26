package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Administrator
 * @date 2020/4/18
 */

@Data
@TableName("role")
public class SysRole {

    private Integer id;

    private String roleName;

    private String roleCode;

    private String roleDescription;
}
