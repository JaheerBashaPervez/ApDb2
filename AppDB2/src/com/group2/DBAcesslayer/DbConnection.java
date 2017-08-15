package com.group2.DBAcesslayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

public class DbConnection {
		
	Connection getDbConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		Connection con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		con.commit();
		return con;
	}
		
	public int registrationInsert(String username,String email,String country,String password) throws SQLException, ClassNotFoundException
	{
		
		Connection con=getDbConnection();
		Statement stmt=con.createStatement(); 
		int x=stmt.executeUpdate("insert into userdetails values('"+username+"','"+email+"','"+country+"','"+password+"')");
		con.close();
		return x;
	}
	public int updateValues(String username,String email,String country)throws SQLException, ClassNotFoundException
	{	
		Connection con=getDbConnection();
		Statement stmt=con.createStatement(); 
		int x=stmt.executeUpdate("update USERDETAILS set email='"+email.trim()+"',country='"+country.trim()+"' where username='"+username+"'");
		con.close();
		return x;
	}
	
	public boolean loginAuthentication(String username,String password) throws SQLException, ClassNotFoundException
	{	boolean flag =false;
		Connection con=getDbConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("Select * from USERDETAILS");
		while(rs.next())
		{
			String usernamedb=rs.getString(1);
			String passworddb=rs.getString(4);
			if(usernamedb.trim().equals(username.trim())&&passworddb.trim().equals(password.trim()))
			{				
				flag= true;
			}
		}
		return flag;
	}
	public int forgotPassword(String uname,String password)throws SQLException, ClassNotFoundException
	{	
		Connection con=getDbConnection();
		Statement stmt=con.createStatement(); 
		int x=stmt.executeUpdate("update USERDETAILS set USERPASWORD ='"+password.trim()+"' where username='"+uname.trim()+"'");
		con.close();
		return x;
		
	}
}

