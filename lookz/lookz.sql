/** 创建数据库 **/
IF EXISTS(SELECT * FROM sys.databases WHERE name = 'lookz')
BEGIN
	DROP DATABASE lookz;
END
ELSE
BEGIN
	CREATE DATABASE lookz
	ON PRIMARY 
	(
		NAME = 'lookz',
		FILENAME = 'D:\database\lookz.mdf',
		SIZE = 50MB,
		MAXSIZE = UNLIMITED,
		FILEGROWTH = 10%
	)
END
GO
                                                                 
/** 选择数据库 **/
USE lookz;
GO

--------------------------------------------------------------------------------------------------
/** 用户表 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'users')
BEGIN
	DROP TABLE users;
END
ELSE
BEGIN
	CREATE TABLE users
	(	
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,		--序列
		name VARCHAR(50) UNIQUE NOT NULL,					--账号
		password VARCHAR(50) NOT NULL,						--密码
		sex VARCHAR(32) NOT NULL,							--性别
		email VARCHAR(32) NOT NULL,							--邮箱
		money NUMERIC(13,2),								--余额
		shoppingCar_id INT,									--购物车ID 
		car_flag INT ,										--购物车标识
		u_flag INT											--用户唯一状态
	)
END


/** 商品表 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'goods')
BEGIN
	DROP TABLE goods;
END
ELSE
BEGIN
	CREATE TABLE goods
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,		--序列
		name VARCHAR(100) NOT NULL,							--商品名
		introduce VARCHAR(200),		                        --商品介绍
		type VARCHAR(32),									--商品类型
		tasteType VARCHAR(32),								--味道类型
		healthType VARCHAR(32),								--健康类型
		manufacturer VARCHAR(32),							--产商，菜系
		price NUMERIC(9,2) NOT NULL,						--单价
		imgUrl VARCHAR(50) NOT NULL,						--图片地址
		evaluate INT CHECK(evaluate >= 0) NOT NULL,			--评论数
		num INT NOT NULL,									--库存
		dicount NUMERIC(3,2),								--折扣
		score INT,											--积分
		goods_flag INT										--商品标识
	)
END


/** 购物车 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'shoppingCar')
BEGIN
	DROP TABLE shoppingCar;
END
ELSE
BEGIN
	CREATE TABLE shoppingCar
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,		--序列
		number INT DEFAULT(1) NOT NULL,						--商品数量
		sum_price NUMERIC(9,2) NOT NULL,					--总价
		time DATETIME DEFAULT(GETDATE()) NOT NULL	,		--购买时间
		shoppingCar_flag INT								--购物车标识
	)
END


/** 订单 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'orders')
BEGIN
	DROP TABLE orders;
END
ELSE
BEGIN
	CREATE TABLE orders
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--序列
		orderid NUMERIC(13) NOT NULL,					--订单号
		payWay VARCHAR(50) NOT NULL,					--支付方式
		time DATETIME DEFAULT(GETDATE()) NOT NULL,		--订单时间
		orderState VARCHAR(32),							--订单状态
		order_flag INT									--订单标识
	)
END



/** 关联表 用户跟订单 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'users_orders')
BEGIN
	DROP TABLE users_orders;
END
ELSE
BEGIN
	CREATE TABLE users_orders
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,
		users_id INT FOREIGN KEY REFERENCES users(id) on delete cascade,
		orders_id NUMERIC(13) 
	)
END


/** 关联表 购物车跟商品 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'shoppingCar_goods')
BEGIN
	DROP TABLE shoppingCar_goods;
END
ELSE
BEGIN
	CREATE TABLE shoppingCar_goods
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,
		shoppingCar_id INT FOREIGN KEY REFERENCES shoppingCar(id) on delete cascade,
		goods_id INT FOREIGN KEY REFERENCES goods(id) on delete cascade
	)
END


/** 关联表 订单跟商品 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'orders_goods')
BEGIN
	DROP TABLE orders_goods;
END
ELSE
BEGIN
	CREATE TABLE orders_goods
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,
		orders_id NUMERIC(13) ,
		goods_id INT FOREIGN KEY REFERENCES goods(id) on delete cascade,
		number INT NOT NULL 
	)
END


/** 联系表我们表 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'contact')
BEGIN
	DROP TABLE contact;
END
ELSE
BEGIN
	CREATE TABLE contact
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--序列
		name varchar(50) NOT NULL,								--姓名
		phone VARCHAR(50) CHECK(phone LIKE '1[3-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,	--电话
		msg VARCHAR(500) NOT NULL,								--留言
		[time] DATETIME DEFAULT(GETDATE()) NOT NULL,				--时间
		contact_flag INT										--联系标识
	)
END


/** passwordProtect密保表 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'passwordProtect')
BEGIN
	DROP TABLE passwordProtect;
END
ELSE
BEGIN
	CREATE TABLE passwordProtect
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--序列
		email VARCHAR(32) NOT NULL,								--邮箱
		ppOne VARCHAR(32) NOT NULL,								--密保问题一
		ppTwo	VARCHAR(32) NOT NULL,							--密保问题二
		ppThree	VARCHAR(32) NOT NULL,							--密保问题三
		pp_flag INT												--密保表状态
	)
END


/** comment用户评论表 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'comment')
BEGIN
	DROP TABLE comment;
END
ELSE
BEGIN
	CREATE TABLE comment
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--序列
		users_id INT NOT NULL,									--用户ID
		users_name VARCHAR(32) NOT NULL,						--用户姓名
		time DATETIME DEFAULT(GETDATE()) NOT NULL,				--时间
		content VARCHAR(500) NOT NULL,							--评论内容
		aritisismType VARCHAR(32) ,								--评论级别
		deliveryType VARCHAR(32) ,								--快递级别
		serveType VARCHAR(32) ,									--服务级别
		comment_flag INT										--评论状态
	)
END


/** deliveryAddress收货地址表 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'deliveryAddress')
BEGIN
	DROP TABLE deliveryAddress;
END
ELSE
BEGIN
	CREATE TABLE deliveryAddress
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--序列
		users_id INT NOT NULL,									--创建地址的用户ID
		name VARCHAR(32) NOT NULL,								--收货人姓名
		phone VARCHAR(50) CHECK(phone LIKE '1[3-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]') NOT NULL,	--电话
		postCode VARCHAR(32) ,									--邮编
		province VARCHAR(32),									--省
		city VARCHAR(32),										--市
		area VARCHAR(32),										--地区
		address VARCHAR(32),									--详细地址
		address_flag INT										--收货表状态
	)
END


/**admin 管理员表 6超级管理员 7普通管理员 **/
IF EXISTS(SELECT * FROM sys.objects WHERE name = 'admins')
BEGIN
	DROP TABLE admins;
END 
ELSE
BEGIN
	CREATE TABLE admins
	(
		id INT IDENTITY(1000,1) PRIMARY KEY NOT NULL,			--序列
		name VARCHAR(32) NOT NULL,								--管理员姓名
		password VARCHAR(32) NOT NULL,							--密码
		admins_rank INT,										--管理员等级
		admins_flag INT											--管理员表状态
	)
END


/**收藏表 **/
/**推荐表**/
----------------------------------------------------------------------------------------------------------
select * from users;
select * from goods;
select * from shoppingCar;
select * from admins;

TRUNCATE TABLE goods;

select top(2) id from goods where type='主菜' order by id;
select top(2) * from goods where type='主菜' and id not in (select top(0) id from goods where type='主菜' order by id) order by id;
select top(2) * from goods where id not in (select top(0) id from goods order by id) order by id;

select e.imgUrl,a.name, b.orders_id,e.name,e.price,d.number,c.[time] from users a,users_orders b,orders c,orders_goods d, goods e where a.id=b.users_id and b.orders_id=c.id and c.id=d.orders_id and d.goods_id=e.id and a.name='一粒蛋';
select e.imgUrl,a.name, b.orders_id,e.name,e.price,d.number,c.time from users a,users_orders b,orders c,orders_goods d, goods e where a.id=b.users_id and b.orders_id=c.orderid and c.orderid=d.orders_id and d.goods_id=e.id and a.name='一粒蛋';