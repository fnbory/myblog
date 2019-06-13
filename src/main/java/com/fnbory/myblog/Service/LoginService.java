package com.fnbory.myblog.Service;


import com.fnbory.myblog.entities.User;

public interface LoginService {
    boolean login(String name,String psw);
    void  register(User user);

}
