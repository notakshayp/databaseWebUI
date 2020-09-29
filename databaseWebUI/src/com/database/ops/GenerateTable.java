package com.database.ops;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class GenerateTable {
	public String createTable(String queryEditor, Connection c) {
		try {
			Statement stmt = null;
			stmt = c.createStatement();
			boolean queryType = stmt.execute(queryEditor);
			if (queryType) {
				// query is a select query.
				ResultSet rs = stmt.getResultSet();

				return resultSetToHTML(rs);
			} else {
				int count = stmt.getUpdateCount();
				return (" <b style=\"color:green\">Total records updated:" + count + "</b>");
			}
		} catch (Exception e) {
			return "<b style=\"color:red\">" + (e.getMessage()) + "</b>";
		}

	}

	public String resultSetToHTML(ResultSet resultSet) {
		String htmlText = "<table class=\"table\"><thead><tr><th scope=\\\"col\\\">S.No</th>";
		try {
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			for (int i = 1; i <= columnsNumber; i++) {
				// genearte headers
				htmlText += "<th scope=\"col\">" + rsmd.getColumnName(i) + "</th>";
			}
			htmlText += "\r\n" + "  </tr>\r\n" + "</thead>\r\n" + "<tbody>";// start body here
			int rownumVal = 1;
			while (resultSet.next()) {
				htmlText += "<tr><th scope=\"row\">" + rownumVal + "</th>";
				for (int i = 1; i <= columnsNumber; i++) {
					String columnValue = resultSet.getObject(i).toString();
					// System.out.print(columnValue + " " + rsmd.getColumnName(i));
					htmlText += "<td>" + resultSet.getString(i) + "</td>";
				}
				htmlText += "</tr>";
			}
			htmlText += "</tbody></table>";

		} catch (Exception e) {
			// TODO: handle exception
		}

		return htmlText;
	}
}
