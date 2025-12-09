package com.jxd.smsnew.controller;

import com.jxd.smsnew.model.UserLogin;
import com.jxd.smsnew.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @PostMapping("/login")
    public UserLogin login(String username, String password, HttpSession session) {
        UserLogin user = loginService.getUserByUsername(username);

        if (user != null && password.equals(user.getPassword())) {
            session.setAttribute("currentUser", user);
            session.setAttribute("username", user.getUsername());
            return user;
        }

        return null;
    }

    @PostMapping("/password/change")
    public boolean changePassword(String oldPassword, String newPassword, HttpSession session) {
        UserLogin user = (UserLogin) session.getAttribute("currentUser");
        if (user != null) {
            if (loginService.changePassword(user.getUsername(), oldPassword, newPassword)) {
                session.invalidate();
                return true;
            }
        }
        return false;
    }
}