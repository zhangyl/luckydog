package com.fast.snail.luckydog.dao.base;


import com.fast.snail.luckydog.api.DynamicColumn;
import com.fast.snail.luckydog.dao.base.object.UserDO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    UserDO selectByPrimaryKey(@Param("entCode") String entCode, @Param("userCode") String userCode);

    @MapKey("userCode")
    Map<String, Object> selectDynamicColumnByPK(
        @Param("entCode") String entCode,
        @Param("primaryKeyList") List<String> primaryKeyList,
        @Param("dynamicColumnList") List<DynamicColumn> dynamicColumnList);

    int insert(@Param("userDO") UserDO userDO);

    int updateUserByPrimaryKey(@Param("userDO") UserDO userDO);
}
