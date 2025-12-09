package com.jxd.smsnew.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxd.smsnew.model.UserLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserLoginDao extends BaseMapper<UserLogin> {

    UserLogin selectByUsername(@Param("username") String username);

    int updatePassword(@Param("username") String username, @Param("password") String password);

    int bulkDelete(List<String> usernames);
}