package com.daliantwop.cloud.daliantwopuser.entity;

import lombok.Data;

/**
 * 登录信息
 * @author Kevin
 * @date 2024/10/17 17:22
 */
@Data
public class LoginForm {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;


}
