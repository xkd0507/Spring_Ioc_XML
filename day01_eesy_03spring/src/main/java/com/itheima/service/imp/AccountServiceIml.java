package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.iml.AccountDaoIml;
import com.itheima.service.IAccountService;

/**
 * @author xkd
 * @create 2019-12-05 23:04
 * 账户的业务层实现类
 */
public class AccountServiceIml implements IAccountService {

    private IAccountDao accountDao = new AccountDaoIml();

    public void saveAccount(){
        accountDao.saveAccount();
    }
}
