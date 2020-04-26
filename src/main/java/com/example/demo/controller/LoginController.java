package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @date 2020/4/4
 */

@Controller
@RequestMapping("/")
public class LoginController {
    @RequestMapping("/loginPage")
    public String hello() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/errorPage")
    public String error() {
        return "error";
    }
}
