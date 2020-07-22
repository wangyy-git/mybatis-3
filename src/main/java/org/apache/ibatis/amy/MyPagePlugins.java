package org.apache.ibatis.amy;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Connection;
import java.util.Properties;

/**
 * 自己的分页插件
 */
//传入 拦截 那个类 四大对象都行 那个方法
// args 这个拦截器需要mybatis传递什么参数 这里的参数是待拦截方法的入参的类
// prepare(Connection connection, Integer transactionTimeout)
@Intercepts(@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class, Integer.class}))
public class MyPagePlugins implements Interceptor {
  private final String PAGE_SQL_ID = "ByPage";//当sql id以此结尾就会被拦截执行
  //自己实现拦截器里面的逻辑
  @Override
  public Object intercept(Invocation invocation) throws Throwable {
    //计划实现逻辑 1 获取count
    // 1.1 拿到连接 1.2 预编译SQL 1.3 执行count
    // 2 分页 mysql使用limit 主要是获取start 和limit 然后替换原来绑定的SQL 有后续mybatis方法执行

    //invocation里面封装了注解里面填写的三个参数
    StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
    return null;
  }

  //返回一个动态代理类对象 target 是自己要在四大对象中哪一个之前执行 传入那个对象
  // 具体哪一个参见注解
  @Override
  public Object plugin(Object target) {
    System.out.println(target.getClass());
    return Plugin.wrap(target,this);
  }

  //获取配置文件内容
  @Override
  public void setProperties(Properties properties) {

  }
}
