package com.xunge.springemp.service.impl;

/**
 * Created by xunge on 2017/6/26.
 */


import com.xunge.springemp.util.CodeUtil;
import com.xunge.springemp.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xunge.springemp.dao.UserDao;
import com.xunge.springemp.pojo.User;
import com.xunge.springemp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    EmailUtil sendMail;


    public boolean login(String username, String password) throws Exception {
        User user = userDao.findByName(username);
        if(user == null) {
            return false;
        }
        if(password.equals(user.getPassword())){
            return true;
        }
        return false;
    }

    public boolean register(String email, String username, String password) throws Exception {

        //生成激活码
        String code= CodeUtil.generateUniqueCode();
        User user=new User(email,username,password,0,code);
        //将用户保存到数据库

        if (userDao.addUser(user)) {
            sendMail.sendMail(email, code);
            return true;
        }

        return false;
    }

    public boolean activeUser(String code) throws Exception {
        if(userDao.activeUser(code)){
            return true;
        }else{
            return false;
        }
    }

    public int checkEmailExist(String email) throws Exception {
        int count = userDao.findByEmail(email);
        if(count == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public int checkUserExist(String user) throws Exception {
        int count = userDao.findByUser(user);
        if(count == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean checkState(String username) throws Exception {
        int result = userDao.findState(username);
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }
}
