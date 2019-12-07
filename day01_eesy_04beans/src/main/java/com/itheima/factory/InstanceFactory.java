package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceIml;

/**
 * @author xkd
 * @create 2019-12-06 16:51
 * 模拟一个工厂类，该类可能是存在于jar包中的，我们无法通过修改源码的方式来提供默认构造造函数
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceIml();
    }
}
