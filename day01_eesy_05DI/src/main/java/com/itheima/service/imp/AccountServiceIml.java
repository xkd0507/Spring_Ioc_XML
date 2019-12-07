package com.itheima.service.imp;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * @author xkd
 * @create 2019-12-05 23:04
 * 账户的业务层实现类
 */
public class AccountServiceIml implements IAccountService {

    //经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceIml(String name, Integer age,
                             Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;

    }
    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了"
                            + name + ", " + age + ", " + birthday);
    }

}
