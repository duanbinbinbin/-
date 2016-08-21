package com.bin.lookz.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据库工具类
 * 	数据源 = 连接池 + 管理方式
 * 		由于 JDBC 中创建连接 以及关闭连接比较耗时 , 所以可以通过数据源技术 来提高效率
 * 		数据源对象在创建的时候会默认启动N个连接 , 所以第一次创建的时候稍慢. 但是后面使用过的时候不再创建连接
 * 		所以使用过的时候速度快 , 而且使用完毕之后不是关闭 , 而是归还 . 这种方式可以提高效率
 */
public class C3P0Util {
	
	//数据库连接属性
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static ComboPooledDataSource cpds;
	
	static{
		try {
			//加载配置文件信息
			ResourceBundle rb = ResourceBundle.getBundle("jdbc");
			//赋值
			driver = rb.getString("driver");
			url = rb.getString("url");
			username = rb.getString("username");
			password = rb.getString("password");
			//创建C3P0数据源对象
			cpds = new ComboPooledDataSource();
			//注册驱动
			cpds.setDriverClass(driver);
			//配置连接信息
			cpds.setJdbcUrl(url);
			cpds.setUser(username);
			cpds.setPassword(password);
			//配置初始连接个数
			cpds.setInitialPoolSize(50);
			//配置最大连接个数
			cpds.setMaxPoolSize(100);
			//配置超时时间
			cpds.setCheckoutTimeout(5000);
			
		} catch (PropertyVetoException e) {
			System.out.println("注册驱动失败 !");
			e.printStackTrace();
		}
	}
	
	//获取连接
	public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = cpds.getConnection();
		} catch (SQLException e) {
			System.out.println("连接获取失败 !");
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭资源 , 如果使用数据源或者连接池等技术 .连接对应的 close 方法不再是关闭 , 而是归还 .
	public static void closeAll(ResultSet rs){
		try {
			if( rs != null ){
				//先获取命令对象
				Statement s = rs.getStatement();
				Connection conn = s.getConnection();
				closeAll( rs,s,conn );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(Statement s,Connection conn){
		try {
			if( s != null ){
				s.close();
			}
			
			if( conn != null ){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(ResultSet rs,Statement s,Connection conn){
		try {
			if( rs != null ){
				rs.close();
			}
		
			if( s != null ){
				s.close();
			}
			
			if( conn != null ){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 通用的查询语句方法
	 * @param sql 指定的SQL语句
	 * @param obj 该SQL语句对应的参数集 , 如果没有则为 null
	 * @return ResultSet 返回对应的结果集对象 . 
	 */
	public static ResultSet query(String sql,Object[] obj){
		//获取连接
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//创建预处理命令对象
			ps = conn.prepareStatement(sql);
			//判断是否有参数
			if( obj != null ){
				//给占位符赋值
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1,obj[i]);
				}
			}
			//执行
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//返回结果集
		return rs;
	}
	
	/**
	 * 通用的增删改语句方法
	 * @param sql 指定的SQL语句
	 * @param obj 该SQL语句对应的参数集 , 如果没有则为 null
	 * @return 返回受影响行数 , 如果为 DDL 语句则为 0. 
	 */
	public static int update(String sql,Object[] obj){
		//获取连接
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int rows = 0;
		
		try {
			//创建预处理命令对象
			ps = conn.prepareStatement(sql);
			//判断是否有参数
			if( obj != null ){
				//给占位符赋值
				for(int i=0;i<obj.length;i++){
					ps.setObject(i+1,obj[i]);
				}
			}
			//执行
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			closeAll(ps,conn);
		}
		//返回受影响行数
		return rows;
	}
	
	
}
