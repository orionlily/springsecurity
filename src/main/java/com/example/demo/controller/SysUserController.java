package com.example.demo.controller;

import com.example.demo.pojo.SysUser;
import com.example.demo.service.SysUserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author li.lc
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Resource(name = "userService")
    private SysUserService sysUserService;

    @GetMapping("/test")
    public String test(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "user test="+authentication.getPrincipal();
    }

    @GetMapping("/getUserByOpt")
    public SysUser getUserByOptController(String opt){
        return sysUserService.getUserByOpt(opt);
    }

    @GetMapping("/getUserByAccount")
    public SysUser getUserByAccountController(String account){
        return sysUserService.getUserInfoByAccount(account);
    }
}
