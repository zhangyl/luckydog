package com.fast.snail.luckydog.biz.user;

import com.fast.snail.luckydog.dao.base.UserMapper;
import com.fast.snail.luckydog.dao.base.object.UserDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;


@Component
public class UserManagerImpl {

    @Resource
    private UserMapper userMapper;


    public UserDO selectByPrimaryKey(String entCode, String userCode) {
        UserDO userDO = userMapper.selectByPrimaryKey(entCode, userCode);

        return userDO;
    }
}
