环境配置：JAVA JDK 1.6；tomcat 6.0；myeclipse 6.5；MySQL 5.0
1、前后端的数据交互问题：
后-前 在jsp中传递、使用（onload方法）
前-后 href中传递
数据格式以json为主

2、为解决jsp#include时多个页面title，css，js冲突，保持简洁采取的办法：
将header中的title去掉，保留meta，引入共用的js和css。
每个页面的主体部分写明title，去掉meta，引用专用的js和css。
foot里面注释掉js和css。