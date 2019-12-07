package com.itheima.factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author xkd
 * @create 2019-12-05 23:23
 * 一个创建Bean对象的工厂
 * Bean在计算机英语中有可重用组件的含义
 * JavaBean:   用java语言编写的可重用组件
 *         javabean > 实体类
 *
 *     它是创建service和dao对象的
 *          1. 需要一个配置文件来配置service和dao
 *              配置的内容：唯一标识 = 全限定类名（key：value）
 *          2. 通过读取配置文件中的内容，反射创建对象
 *
 *          我的配置文件可以是xml也可以是properties
 *          (先创建properties（resource目录下），读取方便，但是在spring中时xml)
 */
public class BeanFactory {

    /**
     * 读取properties文件
     */
    //方法一
    //定义一个properties对象
    private static Properties props;
    /**
     * 为了解决多例的问题，定义一个Map，用于存放要创建的对象，我们把它称之为容器
     */
    private static Map<String, Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try{
            //1.实例化对象
            props = new Properties();
            //2.获取Properties文件的流路经
            //InputStream in = new FileInputStream("");不要用这个，web工程一旦部署之后""中的相对路径绝对用不了
            //应该使用类加载器
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);

            //实例化容器
            beans = new HashMap<String, Object>();
            //去除配置文件中的所有key
            Enumeration keys = props.keys();
            //遍历枚举
            while(keys.hasMoreElements()){
                //去除每一个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);

            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化Porperties失败");
        }
    }


    /**
     * 根据Bean的名称获取Bean对象  单例模式饿汉式
     * */
    public static Object getBean(String beanName){
       return beans.get(beanName);
    }

//    /**
//     * 根据Bean的名称获取Bean对象
//     * */
//    public static Object getBean(String beanName){
//        Object bean = null;
//        String beanPath = props.getProperty(beanName);
//        //System.out.println(beanPath);
//        try {
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
