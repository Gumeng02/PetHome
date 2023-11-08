import org.pet.home.utils.JedisUtil;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/2
 **/
public class RedisExample {
    public static  void main(String[] ages){
        JedisUtil.INSTANCE.set("test","aaa");
        System.out.println(JedisUtil.INSTANCE.get("test"));
    }
}
