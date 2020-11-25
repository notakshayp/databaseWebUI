package com.database.ops;

import java.sql.Connection;
import java.sql.SQLException;

public class RunQuery {
	public String runUserQuery(String dbvendor, String host, String port, String database, String username,
			String password, String queryEditor) throws SQLException {
		CreateConnectionObject conObj = new CreateConnectionObject();

		Connection con = null;
		if (dbvendor.equals("PostgreSQL")) {
			con = conObj.genaratePostgresqlConnection(host, port, database, username, password);
		} else if (dbvendor.equals("MySQL")) {
			con = conObj.genarateMysqlConnection(host, port, database, username, password);
		}
		else if (dbvendor.equals("Oracle")) {
			con = conObj.genarateOracleConnection(host, port, database, username, password);
		}

		if (con == null) {
			return "<b style=\"color:red\">Error Connecting to DB check creds!!<b>";
		} else {
			GenerateTable tableView = new GenerateTable();
			return tableView.createTable(queryEditor, con);
		}

	}
}
