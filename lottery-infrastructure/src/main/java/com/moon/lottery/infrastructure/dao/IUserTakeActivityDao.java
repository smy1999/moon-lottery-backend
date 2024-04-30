package com.moon.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import com.moon.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@Mapper
public interface IUserTakeActivityDao {

    @DBRouter(key = "uId")
    void insert(UserTakeActivity userTakeActivity);
}
