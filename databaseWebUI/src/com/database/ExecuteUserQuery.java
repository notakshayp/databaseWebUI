package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.ops.RunQuery;

/**
 * Servlet implementation class ExecuteUserQuery
 */
@WebServlet("/execute")
public class ExecuteUserQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dbvendor = request.getParameter("dbvendor");
		String host = request.getParameter("host");
		String port = request.getParameter("port");
		String database = request.getParameter("database");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String queryEditor = request.getParameter("queryEditor");
		RunQuery rQuery = new RunQuery();
		String res="";
    try {
      res = rQuery.runUserQuery(dbvendor, host, port, database, username, password, queryEditor);
    } catch (SQLException e) {
	    e.printStackTrace();
    }
    PrintWriter pw = response.getWriter();
    pw.print(res);

	}

}
