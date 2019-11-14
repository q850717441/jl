package com.jl.exe;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jl.vo.SysResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: jl
 * @author: JL
 * @create: 2019-10-31 15:47
 * @description:
 **/
//返回数据为JSON
@RestControllerAdvice  //异常通知 对Controller层生效
@Slf4j                   //记录日志
public class SysExecution {

    //当系统中出现运行时异常时生效
    //区分 系统正常异常和跨域异常
    //说明:跨域访问时用户一定会添加callback参数
    @ExceptionHandler(RuntimeException.class)
    public Object error(Exception exception, HttpServletRequest request) {
        String callback = request.getParameter("callback");
        if (StringUtils.isEmpty(callback)) {
            exception.printStackTrace();
            log.error(exception.getMessage());
            return SysResult.fail();
        } else {
            //用户跨域请求
            exception.printStackTrace();
            log.error(exception.getMessage());
            return new JSONPObject(callback, SysResult.fail());
        }
    }
}