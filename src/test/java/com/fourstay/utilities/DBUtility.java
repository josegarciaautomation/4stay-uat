package com.fourstay.utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class DBUtility {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	// oracle - oracle jdbc driver
	// mysql - mysql driver

	// @Test
	public void getDBDataTest() throws ClassNotFoundException, SQLException {

		// JDBC
		// establish connection to DB
		// in order to connect you need to provide the ip address+db_name,
		// username, password
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_tracker", "root",
				"12345");
		assertNotNull(connection);
		// execute a query
		Statement st = connection.createStatement();
		// parse the query results
		ResultSet res = st.executeQuery("SELECT * FROM student_tracker.student");
		assertNotNull(res);
		// metadata is data about data
		// getColumnCount gets the number of columns from the returned result
		int cols = res.getMetaData().getColumnCount();
		System.out.println(cols);
		String col1 = res.getMetaData().getColumnName(1);
		String col2 = res.getMetaData().getColumnName(2);
		String col3 = res.getMetaData().getColumnName(3);
		String col4 = res.getMetaData().getColumnName(4);

		// res.next90 will iterate though each line
		while (res.next()) {

			// integer parameter is index
			System.out.print(res.getString(1));
			// string parameter colunm name
			System.out.print(" " + res.getString(col2));
			System.out.print(" " + res.getString("last_name"));
			System.out.println(" " + res.getString(col4));
		}

	}

	public static String getDbData(String sql) {
		setResultSet(sql);
		String result = null;
		try {
			// get the first column for the first row
			while (resultSet.next()) {
				result = resultSet.getString(1);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return result;
	}

	/**
	 * 
	 */
	private static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void setResultSet(String sql) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/4stay_test", "root", "root");
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//	@Test
	public void testSingleString() {
		String actual = getDbData("SELECT last_name FROM student_tracker.student where first_name = 'Mary'");
		assertEquals("Public", actual);
	}

	public static List<String> getDbDataList(String sql) {
		setResultSet(sql);
		List<String> result = new ArrayList<>();
		try {
			// get the first column of all rows
			while (resultSet.next()) {
				result.add(resultSet.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return result;
	}

	@Test
	public void testList() {
		String sql = "select last_name FROM 4stay_test.users";
		List<String> result = getDbDataList(sql);
		assertNotNull(result);
		System.out.println(result);
	}

	public static List<Map<String, String>> getDbMap(String sql) {
		setResultSet(sql);
		List<Map<String, String>> result = new ArrayList<>();
		try {
			// get the first column of all rows
			while (resultSet.next()) {
				// create local map for current row
				Map<String, String> currentRow = new HashMap<>();
				// put the information from current row to local map
				for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					// get the column name
					String column = resultSet.getMetaData().getColumnName(i);
					// get value using the column name
					String value = resultSet.getString(column);
					currentRow.put(column, value);
				}
				// add local map of the current to result list
				result.add(currentRow);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return result;
	}

//	@Test
	public void testMap() {
		String sql = "SELECT * FROM student_tracker.student;";
		List<Map<String, String>> result = getDbMap(sql);
		assertNotNull(result);
		for (Map map : result) {
			Set set = map.keySet();
			for (Object key : set) {
				System.out.print(key + "\t");
				System.out.println(map.get(key));
			}
			System.out.println("***************************");
		}
	}
}
