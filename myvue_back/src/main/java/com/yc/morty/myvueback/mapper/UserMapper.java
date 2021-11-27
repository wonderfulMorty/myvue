package com.yc.morty.myvueback.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.morty.myvueback.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity com.yc.morty.myvueback.domain.User
 */

public interface UserMapper extends BaseMapper<User> {
    //分页查询
    Page<User> findPage(Page<User> page, @Param("nickName") String nickName);
}




