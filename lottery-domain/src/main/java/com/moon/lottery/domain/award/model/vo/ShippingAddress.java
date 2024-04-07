package com.moon.lottery.domain.award.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description:
 * @author: smy1999
 * @date: 2024/4/7
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ShippingAddress {

    private String name;

    private Long provinceId;

    private String provinceName;

    private Long cityId;

    private String cityName;

    private Long countyId;

    private String countyName;

    private Long townId;

    private String townName;

    private String address;

    private String phone;

    private String email;

    private String remark;
}
