package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;

/**
 * @author xkd
 * @create 2019-12-05 23:18
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //IAccountService as = new AccountServiceIml();
        //解耦，不在需要导入iml包下的AccountServiceIml类，直接用接口IAccountService进行强转即可
        for (int i = 0; i < 5; i++) {
            //此时as是多例，而不是单例
            //解决多例用单例在beanfactory中修改
            IAccountService as = (IAccountService)BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }


}
