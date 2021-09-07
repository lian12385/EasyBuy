package com.buliang.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
public class ResultVo<T> {
    private int code;
    private String msg;
    private List<T> dataS;

    public ResultVo(ResultCode resultCode,List<T> dataS){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.dataS = dataS;
    }
    public ResultVo(List<T> dataS){
        this(ResultCode.SUCCESS,dataS);
    }

    public static ResultVo success(){
        return new ResultVo(null);
    }

    public static ResultVo mySuccess(ResultCode resultCode){
        return new ResultVo(resultCode,null);
    }


    public static ResultVo fail(ResultCode resultCode){
        return new ResultVo(resultCode,null);
    }

}
