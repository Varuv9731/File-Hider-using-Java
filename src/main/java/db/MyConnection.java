package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	public static Connection connection;	//created a connection variable
	
	public static Connection getConnection() {	
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");//loading class i.e, driver
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ytproject?useSSL=false","root","V2a0r0u3n"); //establishing conection
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		 catch (SQLException e) {
			 e.printStackTrace();
		 }
		 System.out.println("Connection established succesfully");
		return connection;
	}
	
	
	public static void closeConnection() {
		if(connection != null) {
			try {
				connection.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
