package com.itheima.dao.iml;

import com.itheima.dao.IAccountDao;

/**
 * @author xkd
 * @create 2019-12-05 23:14
 * 账户的持久层实现类
 */
public class AccountDaoIml implements IAccountDao {

    public void saveAccount(){
        System.out.println("保存了账户");
    }
}
