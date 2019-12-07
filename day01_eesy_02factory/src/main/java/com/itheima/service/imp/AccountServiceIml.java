package com.itheima.service.imp;

import com.itheima.dao.IAccountDao;
import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * @author xkd
 * @create 2019-12-05 23:04
 * 账户的业务层实现类
 */
public class AccountServiceIml implements IAccountService {

    //private IAccountDao accountDao = new AccountDaoIml();
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

    //private int i=1;  //业务层和持久层很少包含类成员的,这里只是为了验证单例模式的
    public void saveAccount(){
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
