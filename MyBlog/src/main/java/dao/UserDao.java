package dao;

import java.util.List;

import entity.User;

public interface UserDao {
	/**
	 * Returns all the users from the system
	 * 
	 * @return List<User> allUsers
	 */
	List<User> getAllUsers() ;
	
	User getUserById(long id);
	
	void addUser(String name, int age) ;
	
	void addUser(User user);
	
}
