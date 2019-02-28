package com.silent.manage.constants;

/**
 * \* User: silent
 * \* Date: 27/11/17 Time: 09:57
 * \* Description: 通用的系统常量
 * \
 */
public class Constant {

    /**
     * 基础错误有10开头
     */
    public static final Integer RESPONSE_SUCCESS_CODE = 10000;
    public static final String RESPONSE_SUCCESS_MSG = "成功";
    public static final Integer RESPONSE_PARAM_ERROR_CODE = 10001;
    public static final String RESPONSE_PARAM_ERROR_MSG = "缺少必要的参数";
    public static final Integer RESPONSE_TOKEN_ERROR_CODE = 10002;
    public static final String RESPONSE_TOKEN_ERROR_MSG = "访问令牌错误";
    public static final Integer RESPONSE_UN_KNOW_ERROR_CODE = 10003;
    public static final String RESPONSE_UN_KNOW_ERROR_MSG = "未知错误";


    public static final Integer RESPONSE_INSERT_ERROR_CODE = 10004;
    public static final String RESPONSE_INSERT_ERROR_MSG = "数据添加失败";
    public static final Integer RESPONSE_DELETE_ERROR_CODE = 10005;
    public static final String RESPONSE_DELETE_ERROR_MSG = "数据删除失败";
    public static final Integer RESPONSE_UPDATE_ERROR_CODE = 10006;
    public static final String RESPONSE_UPDATE_ERROR_MSG = "数据修改失败";
    public static final Integer RESPONSE_ADD_CACHE_ERROR_CODE = 10007;
    public static final String RESPONSE_ADD_CACHE_ERROR_MSG = "添加缓存失败";

    public static final Integer RESPONSE_FREQUENT_REQUEST_ERROR_CODE = 10008;
    public static final String RESPONSE_FREQUENT_REQUEST_ERROR_MSG = "你请求得太快啦";

    public static final Integer RESPONSE_SYSTEM_EXCEPTION_ERROR_CODE = 10009;
    public static final String RESPONSE_SYSTEM_EXCEPTION_ERROR_MSG = "系统异常";

}
