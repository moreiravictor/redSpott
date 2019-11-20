package redSpott.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import redSpott.model.User;

public class UserDAO {
	private DataSource datasource;
	public UserDAO(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<User> create(User user) {
		try {
			String SQL = "SELECT * FROM tblUser WHRE email = ? and password = ?";
			PreparedStatement stm = datasource.getConnection().prepareStatement(SQL);
			stm.setString(1, user.getEmail());
			stm.setString(2, user.getPassword());
			ResultSet rs = stm.executeQuery();
			ArrayList<User> userArray = new ArrayList<User>();
			while (rs.next()) {
				User temp = new User();
				temp.setId(rs.getInt("idUser"));
				temp.setEmail(rs.getString("email"));
				temp.setName(rs.getString("name"));
				temp.setPassword(rs.getString("password"));
				userArray.add(temp);
			}
			stm.close();
			rs.close();
			return userArray;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
