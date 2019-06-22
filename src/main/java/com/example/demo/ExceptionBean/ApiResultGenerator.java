package com.example.demo.ExceptionBean;

import java.util.List;

public final class ApiResultGenerator {

    //创建普通消息方法
    public static ApiResult result(boolean flag,String msg,Object result,String jumpUrl,int rows,Throwable throwable){
        //创建返回对象
        ApiResult apiResult = ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setMsg(msg == ""?"执行成功":msg);
        apiResult.setJumpUrl(jumpUrl);
        apiResult.setTime(System.currentTimeMillis());
        apiResult.setRows(rows);
        apiResult.setResult(result);

        return apiResult;
    }

    //返回成功视图方法
    public static ApiResult suucessResult(Object result){
        //rows默认为0
        int rows = 0;
        //如果是集合
        if(result instanceof List){
            //获取总数量
            rows = ((List) result).size();
        }

        return result(true,"",result,"",rows,null);
    }

    //返回失败视图的方法
    public static ApiResult errorResult(String msg,Throwable throwable){
        return result(false,msg,"","",0,throwable);
    }


}
