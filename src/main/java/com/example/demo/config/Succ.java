package com.example.demo.config;

import com.example.demo.util.JsonUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li.lc
 */
public class Succ implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> paramMap = new HashMap<>(2);
        paramMap.put("success",Boolean.TRUE);
        paramMap.put("msg","登录成功");
        String result = JsonUtil.ObjToJson(paramMap);
        response.setContentType("Content-type:application/json");
        response.getWriter().write(result);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Map<String,Object> paramMap = new HashMap<>(2);
        paramMap.put("success",Boolean.TRUE);
        paramMap.put("msg","登录成功");
        String result = JsonUtil.ObjToJson(paramMap);
        response.setContentType("Content-type:application/json");
        response.getWriter().write(result);
    }
}
