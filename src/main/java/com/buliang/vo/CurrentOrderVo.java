package com.buliang.vo;

import lombok.Data;

@Data
public class CurrentOrderVo {
    private String serialNumber;
    private double cost;
    private String userAddress;
}
