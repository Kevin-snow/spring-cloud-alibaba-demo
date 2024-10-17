package com.daliantwop.cloud.daliantwopcommon.consts;

/**
 * @author Kevin
 * @date 2024/10/16 14:07
 */
public enum Renum {


    SUCCESS(200, "成功"),
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

    private int code;

    private String msg;
    Renum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取返回消息
     * @param code
     * @return
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
     * @param msg
     * @return
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
