数据库设计

/*数据库名为carpg,数据库字符编码为utf-8*/
create database carpg default charset utf8;

/*用户表user(主要是用户详细信息表单)*/
create table user(
id int primary key not null auto_increment,     /*主键，编号*/
username varchar(20) not null unique,           /*用户名，不为空，并且唯一,用邮箱代替*/
password varchar(32) not null,                  /*密码,存放的是加密后的MD5码（32位）*/
email varchar(30),                              /*邮箱*/
tel varchar(15),								/*联系方式和邮箱用于注册验证，至少选填一个*/
province varchar(30) not null,                  /*省份， 不为空*/
city varchar(30) not null,						/*城市， 不为空*/
section varchar(30),                            /*区*/
/*添加新的字段（2014-11-7）*/
state int not null,                             /*用户状态，0:未验证，1：验证成功,主要用于验证用户注册*/
code varchar(20) not null,                       /*激活码,用于注册验证时匹配使用*/
/*添加新的字段（2014-11-19）*/
name varchar(20) not null                              /*用户别名*/
);

/*汽车分类表car(主要是汽车分类统计的详细信息)*/
create table car(
id int primary key not null auto_increment,     /*主键，编号*/
brand varchar(20) not null,                     /*汽车的品牌，不为空*/
car_type varchar(20) not null,					/*汽车的型号*/
displacement float not null,                    /*汽车的排量，比如1.6L*/
sale_time varchar(20) not null,                 /*汽车的发售时间*/
category varchar(10) not null,                  /*汽车的类别，比如suv或其他的*/
configure varchar(20),							/*汽车的配置，包括豪华，限量，普通等版本*/
alias varchar(20),                               /*汽车的别称*/

/*2014-11-24*/
transmission varchar(10) not null					/*变速器：自动挡，手动挡，混合3中类型*/
standard varchar(10) not null                       /*黄标车标准，主要是国一，国三等*/
);

/*用户实际汽车表user_car(主要是用户自身拥有的汽车的详细信息)*/
create table user_car(
id int primary key not null auto_increment,     /*主键，编号*/
user_id int not null,                           /*用户id，外键，主要和用户表user联立起来*/
user_name varchar(20) not null,                 /*用户名，添加冗余字段*/
car_id int not null,                            /*车的分类编号，主要和汽车分类表car联立起来*/
vin varchar(17) not null,						/*汽车的vin码，可用于识别汽车*/
color varchar(10),								/*汽车的颜色*/
buy_time varchar(20) not null,                  /*汽车购买的时间*/
/*2014-11-26* 修改用户车的属性，将里程添加到抱怨表/
/*mileage int not null,							汽车行驶的里程(单位为公里) */
mileage int,
remark varchar(100)								/*备注信息*/
);

/*抱怨表complaint*/
create table complaint(
id int primary key not null auto_increment,     /*主键，编号*/
user_id int not null,                           /*抱怨人，外键，主要和用户表联立起来*/
user_name varchar(20) not null,                 /*用户名，添加冗余字段*/
user_car_id int not null,                       /*抱怨的车辆，外键，主要和用户汽车表user_car联立起来*/
/*2014-12-1添加冗余字段*/
car_brand varchar(20) not null,					/*添加汽车品牌冗余字段，便于统计*/
problem_id int not null,						/*抱怨的问题，外键，主要和汽车问题类别car_problem联立起来*/
time varchar(20) not null,						/*发送抱怨的时间*/
start_time varchar(20) not null,				/*问题开始的时间,便于统计，只存储年份-月份*/
/*下面的字段未使用11-27*/
frequency varchar(10),							/*问题出现的频率， 比如经常，偶尔，一两次等状况*/
course varchar(50),								/*照成的事故*/
solution varchar(50),							/*解决的方法*/
fee int,										/*花费的金额（单位为元）*/
image varchar(30),                              /*图片详情，存储的是图片的路径*/
mark varchar(100),								/*备注信息*/
/*2014-11-26添加抱怨表的里程属性*/
mileage int not null                            /*汽车行驶里程（单位公里)*/
);

/*汽车问题分类表car_problem(主要是归纳一些普遍存在的汽车问题类别)*/
create table car_problems(
id int primary key not null auto_increment,		/*主键，编号*/
type varchar(30) not null,						/*问题产生的部件，比如引擎，刹车或其他*/
problem varchar(30) not null,					/*问题的状况，比如一个部件下会产生多种不同的问题*/

detail varchar(100)								/*问题的详细描述*/
);