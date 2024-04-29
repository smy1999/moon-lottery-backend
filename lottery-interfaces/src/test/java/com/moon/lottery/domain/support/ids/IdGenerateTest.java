package com.moon.lottery.domain.support.ids;

import com.moon.lottery.BaseTest;
import com.moon.lottery.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
@Slf4j
public class IdGenerateTest extends BaseTest {

    @Resource
    private Map<Constants.Ids, IIdGenerator> idMap;


    @Test
    public void testGenerate() {
        Long id1 = idMap.get(Constants.Ids.SNOWFLAKE).nextId();
        log.info("snowflake: {}", id1);
        Long id2 = idMap.get(Constants.Ids.SHORTCODE).nextId();
        log.info("shortcode: {}", id2);
        Long id3 = idMap.get(Constants.Ids.NUMERIC).nextId();
        log.info("numeric: {}", id3);

    }
}
