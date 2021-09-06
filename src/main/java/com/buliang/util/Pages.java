package com.buliang.util;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Pages<T> {
    private Integer pageIndex;
    private Integer pageSize;
    private Long totalCount;
    private List<T> records;
    //@Getter(AccessLevel.NONE)
    //@Setter(AccessLevel.NONE)
    //private Long totalPages;

    private String url;

    public Long getTotalPages() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }
}
