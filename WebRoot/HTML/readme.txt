环境配置：JAVA JDK 1.6；tomcat 6.0；myeclipse 6.5；MySQL 5.0
1、前后端的数据交互问题：
后-前 在jsp中传递、使用（onload方法）
前-后 href中传递
数据格式以json为主

2、为解决jsp#include时多个页面title，css，js冲突，保持简洁采取的办法：
   将页面拆分为组件（html或之后可改为JS-DOM，组件中需要引用js的直接script引用函数），include入jsp，公共的文件引用在jsp中完成，header因为要处理用户信息，用jsp包装一次

3\路径：JS与Css用相对路径，JSP用绝对路径