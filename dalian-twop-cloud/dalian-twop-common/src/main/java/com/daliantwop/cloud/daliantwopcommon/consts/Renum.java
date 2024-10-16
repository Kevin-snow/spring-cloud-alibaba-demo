package com.daliantwop.cloud.daliantwopcommon.consts;

/**
 * @author Kevin
 * @date 2024/10/16 14:07
 */
public enum Renum {


    SUCCESS(200, "成功"),
    ERROR(500, "内部错误"),
    NOT_FONT(404, "未找到相关内容");

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
