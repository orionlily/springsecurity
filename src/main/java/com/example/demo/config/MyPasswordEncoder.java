package com.example.demo.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author li.lc
 */
public class MyPasswordEncoder implements PasswordEncoder {

    private final String salt = "haha";

    @Override
    public String encode(CharSequence rawPassword) {
        String aaa= DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
        return  aaa;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (!StringUtils.isEmpty(encodedPassword)){
            String a = DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
            if (("{MD5}"+a).equals(encodedPassword)){
                return true;
            }
        }
        return false;
    }
}
