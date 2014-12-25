为解决jsp#include时多个页面title，css，js冲突，保持简洁采取的办法：
将header中的title去掉，保留meta，引入共用的js和css。
每个页面的主体部分写明title，去掉meta，引用专用的js和css。
foot里面注释掉js和css。