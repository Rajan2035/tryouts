package com.myblog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.myblog.database.DatabaseConnection;
import com.myblog.database.DatabaseConnectionMysqlImpl;

import dao.UserDao;
import dao.UserDaoImpl;
import entity.User;

public class DatabaseUtil {
	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		
		List<User> allUsers = userDao.getAllUsers();
		
		printUsers(allUsers);
		
		User shantiram = new User("Shantiram", 25);
		userDao.addUser(shantiram);
		userDao.addUser("Biplav", 30);
		
		
		List<User> allUsersAfterInsertion = userDao.getAllUsers();
		
		printUsers(allUsersAfterInsertion);
		
	}
	
	public static void printUsers(List<User> users) {
		for (User user: users) {
			System.out.println(user);
		}
	}

}
