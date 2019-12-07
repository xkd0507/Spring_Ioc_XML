package com.itheima.service.imp;

import com.itheima.service.IAccountService;

/**
 * @author xkd
 * @create 2019-12-05 23:04
 * 账户的业务层实现类
 */
public class AccountServiceIml implements IAccountService {


    public AccountServiceIml(){
        System.out.println("service对象被创建了");
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了");
    }

    public void init(){
        System.out.println("对象初始化了。。。");
    }
    public void destory(){
        System.out.println("对象销毁了。。。");
    }
}
