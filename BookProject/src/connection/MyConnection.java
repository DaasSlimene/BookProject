package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
public class MyConnection {
	 Connection c =null;
	 Statement stmt =null;
	 public MyConnection() throws ClassNotFoundException, SQLException 
	 {
     }
	 public Connection Myconnect() throws ClassNotFoundException, SQLException 
	 {
		 Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3307/bookstore?serverTimezone=UTC";
	        c = DriverManager.getConnection(url,"root","");
		 return c;
		 }
	public PreparedStatement prepareStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	 }



