package com.fast.snail.luckydog.controller.user;

import com.fast.snail.luckydog.biz.user.UserManagerImpl;
import com.fast.snail.luckydog.controller.HttpResult;
import com.fast.snail.luckydog.controller.user.vo.UserVO;
import com.fast.snail.luckydog.dao.base.object.UserDO;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Resource
    private UserManagerImpl userManager;

    @GetMapping("/user/{userCode}")
    @ResponseBody
    public HttpResult<UserVO> getUserByKey(@PathVariable("userCode") String userCode) {
        HttpResult<UserVO> result = new HttpResult<>();

        UserDO userDO = userManager.selectByPrimaryKey("001", userCode);

        if(userDO == null) {
            result.setSuccess(true);
            return result;
        }

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userDO, userVO);
        result.setData(userVO);

        return result;
    }
}
