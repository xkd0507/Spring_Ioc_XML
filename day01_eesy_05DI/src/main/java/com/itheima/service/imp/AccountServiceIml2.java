package com.itheima.service.imp;

import com.itheima.service.IAccountService;

import java.util.Date;

/**
 * @author xkd
 * @create 2019-12-05 23:04
 * 账户的业务层实现类
 */
public class AccountServiceIml2 implements IAccountService {

    //经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setUserName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount(){
        System.out.println("service中的saveAccount方法执行了"
                            + name + ", " + age + ", " + birthday);
    }

}
