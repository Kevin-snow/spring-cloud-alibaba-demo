package com.daliantwop.cloud.daliantwopcommon.response;

import com.daliantwop.cloud.daliantwopcommon.consts.Renum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Kevin
 * @date 2024/10/16 14:03
 */
@Data
public class R<T> implements Serializable {

    /**
     * 状态码
     */
    private int code;

    /**
     * 状态描述
     */
    private String msg;

    /**
     * 返回值
     */
    private T data;

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public  R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    public static <T> R<?> success(T data){
        return new R<>(Renum.SUCCESS.getCode(), Renum.SUCCESS.getMsg(), data);
    }

    public static R<?> fail(){
        return new R<>(Renum.ERROR.getCode(), Renum.ERROR.getMsg());
    }
}
