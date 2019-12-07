package com.itheima.ui;

import com.itheima.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @create 2019-12-05 23:18
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    private IAccountService as;

    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//在这创建对象
        //2.根据id获取bean对象
//        IAccountService as = (IAccountService)ac.getBean("accountService");
//        as.saveAccount();

//        IAccountService as = (IAccountService)ac.getBean("accountService2");
//        as.saveAccount();

        IAccountService as = (IAccountService)ac.getBean("accountService3");
        as.saveAccount();

    }


}
