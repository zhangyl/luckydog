package com.fast.snail.luckydog.dao.base;


import com.fast.snail.luckydog.dao.base.object.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    UserDO selectByPrimaryKey(@Param("entCode") String entCode, @Param("userCode") String userCode);

    int insert(@Param("userDO") UserDO userDO);

    int updateUserByPrimaryKey(@Param("userDO") UserDO userDO);
}
