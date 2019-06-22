package com.example.demo.ExceptionBean;

import com.example.demo.ExceptionBean.ApiResult;
import com.example.demo.ExceptionBean.ApiResultGenerator;
import org.springframework.web.bind.annotation.*;

/*
全局异常统一类处理
 */
@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class GlobalException {
    /*

     */
    @ExceptionHandler
    @ResponseStatus//异常状态码，默认为500
    public ApiResult runtimeExceptionHandler(Exception e){
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }




}
