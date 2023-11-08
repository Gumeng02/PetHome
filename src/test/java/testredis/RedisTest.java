package testredis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pet.home.MyApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RedisTest {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void setRedis(){
        redisTemplate.opsForValue().set("first","siwei");
        redisTemplate.opsForValue().set("second","siweiWu",30, TimeUnit.SECONDS);
        System.out.println("存入缓存成功");
    }
}
