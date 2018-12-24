
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
