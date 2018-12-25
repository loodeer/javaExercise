
### cron 表达式

秒 分 时 日 月 周 年(可省略)

 ```
 0 15 10 ? * *        | 每天 10 点 15 分触发
 0 0/5 14 * * ?       | 每天下午的 2 点到 2 点 59 分每隔 5 分钟触发一次
 0 15 10 ? * MON-FRI  | 从周一到周五每天上午的 10 点 15 分触发
 0 15 10 ? * 6#3      | 每月的第三周的星期五触发
 0 15 10 ? * 6L 2016-2017 | 从 2016 年到 20117 年每月最后一周的星期五的 10 点 15 分触发
 ```
 
 [cron 表达式在线生成工具](http://www.bejson.com/othertools/cron/)


### quartz

##### 关闭 quartz debug 日志方法

resources 目录下增加 logback.xml 文件，内容如下:

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    log4j.rootLogger=INFO,stdout
    log4j.logger.org.quartz=INFO
</configuration>

```

### JAVA 启动参数解析

[Java启动参数及调优](https://www.cnblogs.com/emberd/p/5973516.html)
- 参数分三类
    - \- 开头，为标准参数，所有的JVM实现都必须实现这些参数的功能，而且**向后兼容**
    - \-X 开头，为非标准参数，默认jvm实现这些参数的功能，但是并不保证所有jvm实现都满足，且**不保证向后兼容**
    - \-XX 开头，为非 Stable 参数，此类参数各个jvm实现会有所不同，将来**可能会随时取消**，需要慎重使用
- 具体参数
    - \-Xms：初始 Heap 大小，使用的最小内存, cpu 性能高时此值应设的大一些
    - \-Xmx：java heap 最大值，使用的最大内存
    - \-Xmn：为新生代的大小
    - \-XX:PermSize: JVM 方法区初始化大小，常量池在此区域
    - \-XX:MaxPermSize: 设定最大内存的永久保存区域
    - \-XX:+HeapDumpOnOutOfMemoryError: 发生 OOM 时生成 dump 文件
    - \-XX:HeapDumpPath=[filepath]: dump 文件，保存在 filepath 下
       


```
/opt/java7/bin/java 
-Djava.util.logging.config.file=/opt/tomcat7/conf/logging.properties 
-Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager 
-server 
-Xms3g # 初始堆大小为 3g
-Xmx3g # 最大允许堆大小为 3g ，两个值推荐设置成一样
-Xmn512m 
-XX:PermSize=128m 
-XX:MaxPermSize=128m 
-Xss256k 
-XX:SurvivorRatio=8 
-XX:CMSInitiatingOccupancyFraction=70 
-XX:+UseConcMarkSweepGC 
-XX:+CMSParallelRemarkEnabled 
-XX:+UseParNewGC 
-XX:+UseCMSCompactAtFullCollection 
-XX:+UseFastAccessorMethods 
-XX:+UseCMSInitiatingOccupancyOnly 
-XX:+HeapDumpOnOutOfMemoryError # OOM 时生成 dump 文件
-XX:HeapDumpPath=/var/log # dump 文件，保存在 filepath 下
-Dcom.sun.management.jmxremote 
-Djava.rmi.server.hostname=127.0.0.1 
-Dcom.sun.management.jmxremote.port=6123 
-Dcom.sun.management.jmxremote.ssl=false 
-Dcom.sun.management.jmxremote.authenticate=false 
-Djava.endorsed.dirs=/opt/tomcat7/endorsed 
-classpath /opt/tomcat7/bin/bootstrap.jar:/opt/tomcat7/bin/tomcat
-juli.jar 
-Dcatalina.base=/opt/tomcat7 
-Dcatalina.home=/opt/tomcat7 
-Djava.io.tmpdir=/opt/tomcat7/temp org.apache.catalina.startup.Bootstrap start
```

### spring

类内能使用资源注解的前提是类以 bean 形式配置。
