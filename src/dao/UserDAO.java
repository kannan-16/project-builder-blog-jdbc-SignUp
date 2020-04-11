package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utility.ConnectionManager;

public class UserDAO implements UserDaoInterface {

	@Override
	public int signUp(User user) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO USERS (email, password) VALUES(?,?)";
		
		int x = 0;
		
		try {
			Connection con = ConnectionManager.getConnection();
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());
			
			x = st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return x;
	}

	@Override
	public boolean loginUser(User user) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?";
		
		Connection con = null;
		try {
			con = ConnectionManager.getConnection();
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user.getEmail());
			st.setString(2, user.getPassword());
			
			ResultSet result = st.executeQuery();
			
			return (result.next());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
}