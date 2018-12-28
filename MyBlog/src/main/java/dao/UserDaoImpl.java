package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myblog.database.DatabaseConnection;
import com.myblog.database.DatabaseConnectionMysqlImpl;

import entity.User;

public class UserDaoImpl implements UserDao {
	
	private DatabaseConnection myConnection;
	
	private Statement statement;
	
	private Connection connection;
	
	public UserDaoImpl() {
		myConnection = new DatabaseConnectionMysqlImpl("localhost", 3306, "test3", 
				"root", "root");
		connection = myConnection.getConnection();
		statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {	
		
		String selectSql = "select * from user";
		List<User> allUsers = new ArrayList<User>();
		ResultSet rs = null;
		try {
			rs = statement.executeQuery(selectSql);
			while(rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				User user = new User(id, name, age);
				allUsers.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return allUsers;
	}

	public User getUserById(long id) {
		String sqlQuery = "select * from user where id=" + id;
		
		ResultSet rs = null;
		User user = null;
		try {
			rs = statement.executeQuery(sqlQuery);
			//todo  what if user provides the id thats not present in database;

			while(rs.next()) {
				long userId = rs.getLong("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				user = new User(id, name, age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}

	public void addUser(String providedName, int providedAge) {
		String sqlQuery = String.format("insert into user(name, age) values ('%s', %d);", 
				providedName, providedAge);
	
		
		try {
			statement.executeUpdate(sqlQuery);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void addUser(User user) {
		this.addUser(user.getName(), user.getAge());
		
	}
	
	

}
