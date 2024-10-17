package com.daliantwop.cloud.daliantwopuser.mapper;

import com.daliantwop.cloud.daliantwopuser.entity.LoginForm;
import com.daliantwop.cloud.daliantwopuser.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author Kevin
 * @date 2024/10/16 18:44
 */
public interface UserMapper {

    /**
     * 根据用户名查询用户信息
     * @param loginForm
     * @return
     */
    User selectUserForLogin(@Param("loginForm") LoginForm loginForm);

}
