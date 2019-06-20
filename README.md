# ssmdemo
首次使用时需要在配置文件目录下配置数据库配置文集db.properties和进行邮件收发的email.properties<br>
其中
db.properties的格式为<br>
driver = 驱动 <br>
url = 数据库连接地址<br>
username = 用户名<br>
password = 密码<br>

# 已知问题
1. 在Spring启动的时候，先启动两个定时进程，启动完成后由启动两个定时线程
已修复
问题原因  tomcat的配置中没有正确的指向war包，导致相关模块被初始化了两次
解决方案 在server.xml中， 正确指向war包路径
