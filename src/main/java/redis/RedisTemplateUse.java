package redis;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author varg
 * @date 2020/8/8 18:47
 */
public class RedisTemplateUse {

    @Resource
    RedisTemplate redisTemplate;

    public void test(){
    }
}
