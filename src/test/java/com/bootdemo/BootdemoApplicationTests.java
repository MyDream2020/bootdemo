package com.bootdemo;

import com.bootdemo.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {BootdemoApplication.class})
class BootdemoApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void contextLoads() {
        redisUtil.set("自增", 99);
        System.out.println(redisUtil.get("自增"));
        redisUtil.incr("自增");
        System.out.println(redisUtil.get("自增"));
    }

}
