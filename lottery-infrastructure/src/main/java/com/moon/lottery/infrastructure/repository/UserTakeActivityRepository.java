package com.moon.lottery.infrastructure.repository;

import com.moon.lottery.domain.activity.repository.IUserTakeActivityRepository;
import com.moon.lottery.infrastructure.dao.IUserTakeActivityDao;
import com.moon.lottery.infrastructure.po.UserTakeActivity;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/6/30
 */
@Repository
public class UserTakeActivityRepository implements IUserTakeActivityRepository {

    @Resource
    private IUserTakeActivityDao userTakeActivityDao;

    @Override
    public void takeActivity(Long uId, Long takeId, Long activityId, String activityName, LocalDateTime partakeDate, Integer takeCount, Integer userTakeLeftCount) {
        UserTakeActivity userTakeActivity = new UserTakeActivity();
        userTakeActivity.setUId(String.valueOf(uId));
        userTakeActivity.setTakeId(takeId);
        userTakeActivity.setActivityId(activityId);
        userTakeActivity.setActivityName(activityName);
        userTakeActivity.setTakeDate(partakeDate);

        if (Objects.isNull(userTakeLeftCount)) {
            // 新增数据
            userTakeActivity.setTakeCount(1);
        } else {
            // 修改数据
            userTakeActivity.setTakeCount(takeCount - userTakeLeftCount + 1);
        }

        String uuid = uId + "_" + activityId + "_" + userTakeActivity.getTakeCount();
        userTakeActivity.setUuid(uuid);

        userTakeActivityDao.insert(userTakeActivity);
    }
}
