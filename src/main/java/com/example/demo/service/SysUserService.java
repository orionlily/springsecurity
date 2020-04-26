package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.SysUserDao;
import com.example.demo.pojo.SysRole;
import com.example.demo.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/4/16
 */
@Slf4j
@Service("userService")
public class SysUserService implements UserDetailsService{

    @Resource(name = "sysUserDao")
    private SysUserDao sysUserDao;

    public SysUser getUserByOpt(String account) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        return sysUserDao.selectOne(queryWrapper);
    }

    public SysUser getUserInfoByAccount(String account){
        return  sysUserDao.getSysUserInfo(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            SysUser sysUser = sysUserDao.getSysUserInfo(username);
            if (sysUser == null){
                return null;
            }
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            for (SysRole sysRole : sysUser.getRoles()){
               authorities.add(new SimpleGrantedAuthority(sysRole.getRoleCode()));
            }

            System.out.println(sysUser);
            System.out.println(authorities);

            /*User user = new User(sysUser.getAccount(),"{noop}"+sysUser.getPassword(),authorities);*/
            return new User(sysUser.getAccount(),sysUser.getPassword(),authorities);
        }catch (Exception e){
            log.error("error");
            return null;
        }

    }
}
