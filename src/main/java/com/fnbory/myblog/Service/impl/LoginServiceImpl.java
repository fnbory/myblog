package com.fnbory.myblog.Service.impl;

import cn.hutool.crypto.SecureUtil;
import com.fnbory.myblog.Service.LoginService;
import com.fnbory.myblog.dao.UserMapper;
import com.fnbory.myblog.entities.User;
import com.fnbory.myblog.entities.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean login(String name, String psw) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andUserNameEqualTo(name).andUserPasswordEqualTo(SecureUtil.md5(psw));
        if(userMapper.selectByExample(userExample).size()!=0) return true;
        return false;
    }

    @Override
    public void register(User user) {

    }
}
