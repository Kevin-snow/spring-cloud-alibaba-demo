package com.daliantwop.cloud.daliantwopuser.controller;

import com.daliantwop.cloud.daliantwopcommon.consts.Renum;
import com.daliantwop.cloud.daliantwopcommon.response.R;
import com.daliantwop.cloud.daliantwopcommon.utils.JwtUtil;
import com.daliantwop.cloud.daliantwopuser.entity.LoginForm;
import com.daliantwop.cloud.daliantwopuser.entity.LoginResponse;
import com.daliantwop.cloud.daliantwopuser.entity.User;
import com.daliantwop.cloud.daliantwopuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Kevin
 * @date 2024/10/17 17:19
 */
@RestController
public class LoginController {

    @Value("${secretKey:dalian-pp}")
    private String secretKey;

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public R<?> login(@RequestBody LoginForm loginForm, BindingResult result) {

        if (result.hasErrors()) {
            return R.error(Renum.PARAMETER_ILLEGAL.getCode(), Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
        }

        User user = userService.getUser(loginForm);
        if (!Objects.isNull(user)) {
            //生成token
            String token = JwtUtil.generateToken(user.getUserName(), secretKey);

            //  生成刷新Token
            String refreshToken = UUID.randomUUID().toString().replace("-", "");

            //将信息放入缓存
            HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
            hashOperations.put(loginForm.getAccount(), "token", token);
            hashOperations.put(loginForm.getAccount(), "refreshToken", refreshToken);
            stringRedisTemplate.expire(loginForm.getAccount(), JwtUtil.TOKEN_EXPIRE_TIME, TimeUnit.MILLISECONDS);
            return R.success(new LoginResponse(token, refreshToken, loginForm.getAccount()));
        }

        return R.fail();
    }


}
