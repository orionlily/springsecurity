package com.example.demo;

import com.example.demo.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class DemoApplicationTests {

    @Resource(name = "userService")
    private SysUserService sysUserService;

	@Test
	void contextLoads() {

	}

	@Test
    void aa(){
        System.out.println(sysUserService.getUserByOpt("admin"));
    }

}
