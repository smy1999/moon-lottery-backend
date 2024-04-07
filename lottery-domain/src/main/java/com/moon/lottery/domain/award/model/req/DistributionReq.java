package com.moon.lottery.domain.award.model.req;

import com.moon.lottery.domain.award.model.vo.ShippingAddress;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DistributionReq {

    private Long uId;

    private Long orderId;

    private Long awardId;

    private String awardName;

    private String awardContent;

    // 送货地址对象
    private ShippingAddress shippingAddress;

    private String extraInfo;

    public DistributionReq(Long uId, Long orderId, Long awardId) {
        this.uId = uId;
        this.orderId = orderId;
        this.awardId = awardId;
    }

    public DistributionReq(Long uId, Long orderId, Long awardId, String awardName, String awardContent) {
        this(uId, orderId, awardId);
        this.awardName = awardName;
        this.awardContent = awardContent;
    }

    public DistributionReq(Long uId, Long orderId, Long awardId, String awardName, String awardContent, ShippingAddress shippingAddress) {
        this(uId, orderId, awardId, awardName, awardContent);
        this.shippingAddress = shippingAddress;
    }
}