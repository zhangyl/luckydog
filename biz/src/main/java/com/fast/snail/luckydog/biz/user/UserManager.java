package com.fast.snail.luckydog.biz.user;



import com.fast.snail.luckydog.dao.base.object.UserDO;

public interface UserManager {

    UserDO selectByPrimaryKey(String entCode, String userCode);

}
