package com.daliantwop.cloud.daliantwopuser.entity;

import lombok.Data;

/**
 * @author Kevin
 * @date 2024/10/17 17:49
 */
@Data
public class LoginResponse {

    private String token;

    private String refreshToken;

    private String account;

    public LoginResponse(String token, String refreshToken, String account) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.account = account;
    }
}
