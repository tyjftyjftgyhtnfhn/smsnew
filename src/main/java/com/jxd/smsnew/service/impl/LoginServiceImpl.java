package com.jxd.smsnew.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.smsnew.dao.IUserLoginDao;
import com.jxd.smsnew.model.UserLogin;
import com.jxd.smsnew.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private IUserLoginDao userLoginDao;

    @Override
    public UserLogin getUserByUsername(String username) {
        // 使用 QueryWrapper 构建查询条件
        QueryWrapper<UserLogin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userLoginDao.selectOne(queryWrapper);
    }

    @Override
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        UserLogin user = getUserByUsername(username);
        // 直接比较明文密码
        if (user != null && oldPassword.equals(user.getPassword())) {
            user.setPassword(newPassword);
            return userLoginDao.updateById(user) > 0;
        }
        return false;
    }
}