package com.feivirus.cglib;

import net.sf.cglib.proxy.Enhancer;

public class Cglib {
    public static void main(String[] args) {
        UserDaoProxy daoProxy = new UserDaoProxy();
        
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(daoProxy);
        
        UserDao userDao = (UserDao)enhancer.create();
        userDao.selectUser();
    }
}
