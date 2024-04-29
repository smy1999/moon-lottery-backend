package com.moon.lottery.domain.support.ids.policy;

import com.moon.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Random;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/29
 */
@Component
public class ShortCode implements IIdGenerator {
    @Override
    public Long nextId() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // 乱序: 2020年为准 + 小时 + 周 + 日 + 三位随机数
        String str = String.valueOf(year - 2020) +
                hour +
                String.format("%02d", week) +
                day +
                String.format("%03d", new Random().nextInt(1000));
        return Long.parseLong(str);
    }
}
