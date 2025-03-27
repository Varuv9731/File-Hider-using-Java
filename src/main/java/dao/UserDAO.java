package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.MyConnection;
import model.User;

public class UserDAO {
	public static boolean isExists(String email) throws SQLException {
		Connection connection = MyConnection.getConnection();  //connecting to MySql
		PreparedStatement ps = connection.prepareStatement("select email from users"); //writing query to get all email from the users
		ResultSet rs = ps.executeQuery(); // executing query and storing in the ResultSet
		while(rs.next()) {      // until rs completes
			String e = rs.getString(1);  //adding email to e every time
			if(e.equals(email)) {		 //comparing email
				return true;
			}
		}
		return false;
	}
	
	//if user doesn't exist
	public static int saveUser(User user) throws SQLException {
		Connection connection = MyConnection.getConnection(); 
		PreparedStatement ps = connection.prepareStatement("insert into users values(default,?,?)");
		ps.setString(1,user.getName());
		ps.setString(2,user.getEmail());
		return ps.executeUpdate();  	
	}
}
