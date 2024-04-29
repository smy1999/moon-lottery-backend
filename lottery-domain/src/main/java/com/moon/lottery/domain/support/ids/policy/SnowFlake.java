package com.moon.lottery.domain.support.ids.policy;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import com.moon.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
@Component
public class SnowFlake implements IIdGenerator {

    private Snowflake snowflake;

    @PostConstruct
    private void init() {
        // 通过 hutool NetUtil 获取ip地址, 通过位运算保证位数S
        long workId;
        try {
            workId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        } catch (Exception e) {
            workId = NetUtil.getLocalhostStr().hashCode();
        }
        workId = workId >> 16 & 31;
        long dataCenterId = 1L;

        // 初始化 snowflake
        snowflake = IdUtil.createSnowflake(workId, dataCenterId);
    }

    @Override
    public Long nextId() {
        return snowflake.nextId();
    }
}
