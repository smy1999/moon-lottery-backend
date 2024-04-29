package com.moon.lottery.domain.support.ids;

import com.moon.lottery.common.Constants;
import com.moon.lottery.domain.support.ids.policy.Numeric;
import com.moon.lottery.domain.support.ids.policy.ShortCode;
import com.moon.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
@Configuration
public class IdContext {

    /**
     * 策略模式,配置id生成策略
     */
    @Bean
    public Map<Constants.Ids, IIdGenerator> init(ShortCode shortCode, SnowFlake snowFlake, Numeric randomNumeric) {
        Map<Constants.Ids, IIdGenerator> IdGeneratorMap = new ConcurrentHashMap<>(8);
        IdGeneratorMap.put(Constants.Ids.SHORTCODE, shortCode);
        IdGeneratorMap.put(Constants.Ids.NUMERIC, randomNumeric);
        IdGeneratorMap.put(Constants.Ids.SNOWFLAKE, snowFlake);
        return IdGeneratorMap;
    }

}
