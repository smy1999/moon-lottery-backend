package com.moon.lottery.infrastructure.dao;

import com.moon.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/6
 */
@Mapper
public interface IAwardDao {

    Award queryAwardByAwardId(Long awardId);
}
