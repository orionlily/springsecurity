package com.example.demo.config;

import com.example.demo.util.JsonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author li.lc
 */
public class Fail implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        String errMsg = exception.getMessage();
        Map<String,Object> paramMap = new HashMap<>(2);
        paramMap.put("success",Boolean.FALSE);
        paramMap.put("msg",errMsg);
        response.setContentType("Content-type:application/json");
        String result = JsonUtil.ObjToJson(paramMap);
        response.getWriter().write(result);
    }
}
