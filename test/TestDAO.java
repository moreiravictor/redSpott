package redSpott.dao;

import java.util.List;
import org.junit.Test;

import redSpott.model.User;

public class TestDAO {
	
	@Test
	public void test01() {
		DataSource datasource = new DataSource();
		UserDAO userdao = new UserDAO(datasource);
		User user = new User();
		user.setEmail("victormoreira176@hotmail.com");
		user.setPassword("senhaTest");
		List<User> listuser = userdao.read(user);
		for (User userla : listuser) {
			System.out.println(userla.getEmail());
			System.out.println(userla.getName());
			System.out.println(userla.getPassword());
		}
	}
}
