package com.buliang.bo;

import lombok.Data;

//业务对象的父类
@Data
public abstract class BaseBo {
    private int startIndex;
    private int pageSize;
    private boolean isPage;
    private int pageIndex;  //当前页码

    public int getStartIndex() {
            if(pageIndex < 1){
                return 0;
            }
            return (pageIndex - 1) * pageSize;
    }
}
