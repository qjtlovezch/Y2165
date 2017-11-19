package cn.blog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 数据访问工具类
 * @version 1.1
 * @author happy
 *
 */
public class BaseDao {
	// 01. 基础内容的准备
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=UTF-8";
	private static final String username="root";
	private static final String pwd="1234";

	//02, 接口对象的准备
	Connection con=null;
	PreparedStatement ps=null;
	public ResultSet rs=null;

	/**
	 * 01.写一个用户获取到一个连接对象的方法，方法的返回值是Connection类型
	 * @return   连接对象
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception{
		Class.forName(driver);
		//什么条件下，构建connection对象
		if (con==null||con.isClosed()) {
			con=DriverManager.getConnection(url, username, pwd);
		}
		//同志们碰到一个
		return con;
	}




	/**
	 * 执行查询操作  目的：返回一个读取器
	 * @param sql  sql语句
	 * @param objs  参数列表
	 * @return     读取器对象
	 * @throws Exception
	 */
	public ResultSet  executeQuery(String sql,Object... objs) throws Exception{
		con=getConnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objs.length; i++) {
			ps.setObject(i+1, objs[i]);
		}
		rs= ps.executeQuery();
		return rs;
	}

	/**
	 * 执行增删该操作
	 * @param sql  sql语句
	 * @param objs  参数列表
	 * @return     受影响行数
	 * @throws Exception
	 */
	public int executeUpdate(String sql,Object... objs) throws Exception{
		con=getConnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < objs.length; i++) {
			ps.setObject(i+1, objs[i]);
		}
		int count = ps.executeUpdate();
		return count;
	}




	/**
	 * 回收连接资源
	 * @throws Exception
	 */
	public void closeAll() throws Exception{
		//倒着回收
		if(rs!=null){
			rs.close();
		}
		if (ps!=null) {
			ps.close();
		}
		if(con!=null){
			con.close();
		}
	}

}














