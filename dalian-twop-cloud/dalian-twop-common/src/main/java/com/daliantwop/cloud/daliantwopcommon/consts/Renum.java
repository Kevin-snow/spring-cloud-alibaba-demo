package com.daliantwop.cloud.daliantwopcommon.consts;

import lombok.Getter;

/**
 * 常用状态枚举类
 * @author Kevin
 * @date 2024/10/16 14:07
 */

@Getter
public enum Renum {


    SUCCESS(200, "操作成功"),
    ERROR(500, "内部错误"),
    NOT_FONT(404, "未找到相关内容"),
    INVALID_TOKEN(407, "无效的token"),
    EXPIRED_TOKEN(408, "过期的token"),
    SIGNATURE_INVALID_TOKEN(409, "无效的签名"),
    MISSION_TOKEN(501, "缺失token"),
    REFRESH_TOKEN_INVALID(502, "刷新Token无效"),
    UNKNOWN_ERROR(509, "未知错误"),
    PARAMETER_ILLEGAL(400, "参数不合法")
    ;

    private final int code;

    private final String msg;
    Renum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /**
     * 获取返回消息
     * @param code 编码
     * @return 消息
     */
    public static String getMsg(int code) {
        for (Renum value : Renum.values()) {
            if (value.getCode() == code) {
                return value.getMsg();
            }
        }
        return null;
    }

    /**
     * 获取返回值
     * @param msg 消息
     * @return 编码
     */
    public static int getCode(String msg) {
        for (Renum value : Renum.values()) {
            if (value.getMsg().equals(msg)) {
                return value.getCode();
            }
        }
        return 0;
    }

}
