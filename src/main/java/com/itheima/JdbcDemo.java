package com.itheima;

import java.sql.*;

/**
 * @author xkd
 * @create 2019-12-05 22:15
 */

/**
 * 程序的耦合
 *      耦合：程序间的依赖
 *          包括：
 *              类之间的依赖
 *              方法间的依赖
 *      解耦： 降低程序间的依赖关系
 *
 *      程序开发中：
 *          应该做到编译时不依赖，运行时才依赖
 *
 *      解耦的思路：
 *          第一步：使用反射来创建对象，而避免使用new关键字；(注册驱动部分)
 *          第二步：通过读取配置文件来获取要创建的对象全限定类名（新问题的解决方法）
 */
public class JdbcDemo {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //ctrl+alt+t 出现try catch
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");  //新问题：导致这个字符串在类中写死，如果换数据库的话oracle，db2等，就需要改
        //实测：反射慢的要死

        //2.获取链接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC", "root", "123456");
        //3.获取操作数据库的处理对象
        PreparedStatement pstm = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();

    }
}
