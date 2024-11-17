package com.fast.snail.luckydog.controller.user;

import com.fast.snail.luckydog.api.DynamicColumn;
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

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    @Resource
    private UserManagerImpl userManager;

    @GetMapping("/user/{userCode}")
    @ResponseBody
    public HttpResult<UserVO> getUserByKey(@PathVariable("userCode") String userCode) {
        HttpResult<UserVO> result = new HttpResult<>();

        List<DynamicColumn> dynamicColumnList = new ArrayList<>();
        {
            DynamicColumn item = new DynamicColumn();
            item.setColumnName("create_time");
            item.setColumnValue("2024-11-17 17:55:00.000000");

            dynamicColumnList.add(item);

        }

        UserDO userDO = userManager.selectByPrimaryKey("001", userCode, dynamicColumnList);

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
