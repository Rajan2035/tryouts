package com.myblog.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnectionMysqlImpl implements DatabaseConnection {
	
	private String host;
	private int port;
	private String schema;
	private String username;
	private String password;
	
	
	
	public DatabaseConnectionMysqlImpl(String host, int port, String schema, String username, String password) {
		this.host = host;
		this.port = port;
		this.schema = schema;
		this.username = username;
		this.password = password;
	}



	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException ce) {
			System.out.println("Cannot find the driver");
		}
		
		Connection conn = null;

		try {
			 conn = DriverManager.getConnection("jdbc:mysql://" + this.host+":"+ this.port+"/" + this.schema, this.username, this.password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Couldn't connect to sql servier");
		}
		
		return conn;
	}

}
