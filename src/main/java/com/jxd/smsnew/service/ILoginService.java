package com.jxd.smsnew.service;

import com.jxd.smsnew.model.UserLogin;

public interface ILoginService {
    UserLogin getUserByUsername(String username);
    boolean changePassword(String username, String oldPassword, String newPassword);
}