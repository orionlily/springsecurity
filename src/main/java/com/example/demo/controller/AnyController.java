package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author li.lc
 */
@RestController
@RequestMapping("/any")
public class AnyController {

    @GetMapping("/test")
    public String test(){
        String currentUser;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if(principal instanceof UserDetails) {
            currentUser = ((UserDetails)principal).getUsername();
        }else {
            currentUser = principal.toString();
        }
        return "any test:some product info,currentUser is: "+currentUser;
    }
}
