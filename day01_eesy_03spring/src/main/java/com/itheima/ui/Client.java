package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.imp.AccountServiceIml;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @create 2019-12-05 23:18
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    private IAccountService as;

    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个实现类：
     *      ClassPathXmlApplicationContext: 它可以实现类路径下的配置文件，要求配置文件必须在类路径下（更常用）
     *      FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件（必须要有访问权限）
     *      AnnotationConfigApplicationContext:它可以解读注解创建容器的
     *
     * 核心容器的两个接口引发出的问题：
     *    ApplicationContext：     单例模式适用      更常用
     *       它在构建核心容器时，创建对象采取的策略是立即加载的方式。也就是说，只要一读取完配置文件马上就创建配置文件中配置的对象
     *    BeanFactory：            多例模式适用
     *       它在构建核心容器时，创建对象采取的策略是延迟加载的方式。也就是说，什么时候根据id获取对象了，什么时候才真正的创建对象
     */
    public static void main(String[] args) {

        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");//在这创建对象
        //2.根据id获取bean对象
        IAccountService as = (IAccountService)ac.getBean("accountService");
        IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);

        System.out.println(as);
        System.out.println(adao);
//        IAccountService as = new AccountServiceIml();
//        System.out.println(as);
//        as.saveAccount();

        //--------BeanFactory----
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as2 = (IAccountService)factory.getBean("accountService");//在这创建对象
        System.out.println(as2);

    }


}
