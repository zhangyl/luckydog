package com.fast.snail.lukydog.controller.user;

import com.fast.snail.lukydog.controller.HttpResult;
import com.fast.snail.lukydog.controller.user.vo.UserVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    @ResponseBody
    public HttpResult<UserVO> getUserByKey() {
        HttpResult<UserVO> result = new HttpResult<UserVO>();
        return result;
    }
}
