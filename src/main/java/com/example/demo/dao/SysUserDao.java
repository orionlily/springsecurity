package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2020/4/16
 */
@Repository
public interface SysUserDao extends BaseMapper<SysUser>{

    SysUser getSysUserInfo(@Param("account") String account);
}
