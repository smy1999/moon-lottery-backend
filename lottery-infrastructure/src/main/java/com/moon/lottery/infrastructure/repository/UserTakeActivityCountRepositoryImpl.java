package com.moon.lottery.infrastructure.repository;

import com.moon.lottery.domain.activity.repository.IUserTakeActivityCountRepository;
import com.moon.lottery.infrastructure.dao.IUserTakeActivityCountDao;
import com.moon.lottery.infrastructure.po.UserTakeActivityCount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/30
 */
@Slf4j
@Repository
public class UserTakeActivityCountRepositoryImpl implements IUserTakeActivityCountRepository {

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Override
    public int subtractLeftCount(Long uId, Long activityId, Integer takeCount, Integer userTakeLeftCount) {

        UserTakeActivityCount userTakeActivityCount = new UserTakeActivityCount();
        userTakeActivityCount.setUId(uId);
        userTakeActivityCount.setActivityId(activityId);

        if (Objects.isNull(userTakeLeftCount)) {
            // 新增记录
            userTakeActivityCount.setTotalCount(takeCount);
            userTakeActivityCount.setLeftCount(takeCount - 1);
            userTakeActivityCountDao.insert(userTakeActivityCount);
            return 1;
        } else {
            // 修改记录
            return userTakeActivityCountDao.updateLeftCount(userTakeActivityCount);
        }
    }
}
