package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.lc
 */
@RestController
@RequestMapping("/")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/world")
    public String world(){
       /* String currentUser = "";
        final Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            currentUser = ((UserDetails) principal).getUsername();
        } else {
            currentUser = principal.toString();
        }*/
        return "world:";
    }
}
