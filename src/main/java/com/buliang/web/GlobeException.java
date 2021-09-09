package com.buliang.web;

import com.buliang.exc.EBuyExc;
import com.buliang.vo.ResultCode;
import com.buliang.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobeException {
    @ExceptionHandler(EBuyExc.class)
    @ResponseBody
    public ResultVo handlerEBuyExc(Exception e){
        ResultCode.Fail.setMsg(e.getMessage());
        return ResultVo.fail(ResultCode.Fail);
    }
}
