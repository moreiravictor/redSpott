package redSpott.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import redSpott.model.User;

public class UserDAO {
	private DataSource datasource;
	public UserDAO(DataSource datasource) {
		this.datasource = datasource;
	}
	
	public List<User> read(User user) {
		try {
			String SQL = "SELECT * FROM tblUser WHERE email = ? and password = ?";
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
	
	public void create(User user) {
		try {
			String SQL = "INSERT INTO tblUser (name, email, password) values (?, ?, ?)";
			PreparedStatement stm = datasource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, user.getName());
			stm.setString(2, user.getEmail());
			stm.setString(3, user.getPassword());
			int res = stm.executeUpdate();
			
			if (res!=0) {
				ResultSet rs = stm.getGeneratedKeys();
				if(rs.next()) {
					user.setId(rs.getInt(1));
				}
				rs.close();
			}
			stm.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
