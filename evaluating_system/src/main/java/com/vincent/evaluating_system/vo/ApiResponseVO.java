package com.vincent.evaluating_system.vo;

import java.util.HashMap;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：21:54
 * <p>
 * value object for api
 * {
 * <p>
 * }
 */
public class ApiResponseVO extends HashMap<String, Object> {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private ApiResponseVO apiResponseVO;

        public Builder() {
            apiResponseVO = new ApiResponseVO();
        }

        public Builder buildResponseCode(ResponseCode responseCode) {
            apiResponseVO.put(KEY_CODE, responseCode.code);
            apiResponseVO.put(KEY_CODE_DESCRIPTION, responseCode.toString());
            return this;
        }

        public Builder buildResponseMsg(String msg) {
            apiResponseVO.put(KEY_MSG, msg);
            return this;
        }

        public Builder builderData(String dataKey, Object data) {
            apiResponseVO.put(dataKey, data);
            return this;
        }


        public Builder builderDefault() {
            apiResponseVO.put(KEY_CODE, ResponseCode.SUCCESS_CODE.code);
            apiResponseVO.put(KEY_CODE_DESCRIPTION, ResponseCode.SUCCESS_CODE.toString());
            apiResponseVO.put(KEY_MSG, DEFAULT_SUCC_MSG);
            return this;
        }

        public ApiResponseVO build() {
            return apiResponseVO;
        }
    }

    //    键
    private static final String KEY_CODE = "code";
    private static final String KEY_CODE_DESCRIPTION = "code_desc";
    private static final String KEY_MSG = "msg";

    public enum ResponseCode {
        //    操作成功
        SUCCESS_CODE(2200),
        //    参数错误
        PARAM_ERROR_CODE(4403),
        //   未登录
        UNAUTHENTICATED_CODE(4401),
        //   未授权，拒绝访问
        UNAUTHORIZED_CODE(4402),
        //   token过期
        TOKEN_TIMEOUT_CODE(4433),
        //   服务端异常
        SERVER_ERR_CODE(5500);

        public final int code;

        ResponseCode(int code) {
            this.code = code;
        }

    }


    //    值
    public static final String DEFAULT_SUCC_MSG = "success";


}
