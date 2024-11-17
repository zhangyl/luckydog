package com.fast.snail.luckydog.biz.user;

import com.fast.snail.luckydog.api.DynamicColumn;
import com.fast.snail.luckydog.dao.base.UserMapper;
import com.fast.snail.luckydog.dao.base.object.UserDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component
public class UserManagerImpl {

    @Resource
    private UserMapper userMapper;


    public UserDO selectByPrimaryKey(String entCode, String userCode, List<DynamicColumn> dynamicColumnList) {
        UserDO userDO = userMapper.selectByPrimaryKey(entCode, userCode);
        if(userDO != null && !CollectionUtils.isEmpty(dynamicColumnList)) {
            List<String> primaryKeyList = new ArrayList<>();
            primaryKeyList.add(userDO.getUserCode());
            Map<String, Object> extraData = userMapper.selectDynamicColumnByPK(entCode, primaryKeyList, dynamicColumnList);
            userDO.setExtraData(extraData);
        }
        return userDO;
    }
}
