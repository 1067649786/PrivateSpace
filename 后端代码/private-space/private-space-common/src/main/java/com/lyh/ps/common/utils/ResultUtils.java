package com.lyh.ps.common.utils;

import com.lyh.ps.common.entity.ResultEntity;

public class ResultUtils {

    private static final String TYPE_RESULT_FAIL = "fail";
    private static final String TYPE_RESULT_SUCCESS = "success";
    private static final Integer RESULT_SUCCESS_CODE = 1;
    private static final Integer RESULT_FAIL_CODE = 2;

    public static ResultEntity createFailResultEntity(String message){
        return new ResultEntity(null,message,RESULT_FAIL_CODE,TYPE_RESULT_FAIL);
    }

    public static ResultEntity createSuccessResultEntity(String message,Object body){
        return new ResultEntity(body,message,RESULT_SUCCESS_CODE,TYPE_RESULT_SUCCESS);
    }
}
