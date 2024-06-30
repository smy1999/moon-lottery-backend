package com.moon.lottery.infrastructure.dao;

import com.moon.middleware.db.router.annotation.DBRouter;
import com.moon.lottery.infrastructure.po.UserTakeActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/16
 */
@Mapper
public interface IUserTakeActivityCountDao {

    @DBRouter(key = "uId")
    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount req);

    /**
     * 新增记录
     *
     * @param userTakeActivityCount
     * @return
     */
    void insert(UserTakeActivityCount userTakeActivityCount);


    /**
     * 更新updateLeftCount
     *
     * @param userTakeActivityCount
     * @return
     */
    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);
}
