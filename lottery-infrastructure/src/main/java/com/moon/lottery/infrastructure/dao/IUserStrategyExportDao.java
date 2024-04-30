package com.moon.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import com.moon.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/30
 */
@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}
