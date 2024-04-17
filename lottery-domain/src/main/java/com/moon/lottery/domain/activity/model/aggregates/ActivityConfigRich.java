package com.moon.lottery.domain.activity.model.aggregates;

import com.moon.lottery.domain.activity.model.vo.ActivityVO;
import com.moon.lottery.domain.activity.model.vo.AwardVO;
import com.moon.lottery.domain.activity.model.vo.StrategyVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/17
 */
@Builder
@Data
@AllArgsConstructor
public class ActivityConfigRich {

    private ActivityVO activityVO;

    private StrategyVO strategyVO;

    private List<AwardVO> awardList;
}
