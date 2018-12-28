package com.myblog.database;

import java.sql.Connection;

public interface DatabaseConnection {

	/**
	 * Returns Database Connection object
	 * 
	 * @param host
	 * @param port
	 * @param schema
	 * @param username
	 * @param password
	 * @return
	 */
	Connection getConnection();
}
