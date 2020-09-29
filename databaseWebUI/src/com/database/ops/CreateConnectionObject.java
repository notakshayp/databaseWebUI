package com.database.ops;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnectionObject {

	Connection c = null;

	public Connection genaratePostgresqlConnection(String host, String port, String database, String user,
			String password) {

		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/" + database, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}

	public Connection genarateMysqlConnection(String host, String port, String database, String user, String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return c;
	}

}
