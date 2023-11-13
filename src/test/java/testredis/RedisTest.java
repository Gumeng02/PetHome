package testredis;

import org.junit.runner.RunWith;
import org.pet.home.MyApplication;
import org.pet.home.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/6
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MyApplication.class},webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RedisTest {
    @Autowired
    private UsersMapper usersMapper;


}
