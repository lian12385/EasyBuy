package com.buliang.bo;

import lombok.Data;

//业务对象的父类
@Data
public abstract class BaseBo {
    private int startIndex;
    private int pageSize;
    private boolean isPage;
}
