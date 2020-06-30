package javaEE;

import java.sql.*;


public class Createtable {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL ="jdbc:mysql://localhost/employee";
	
	// Database credentials
	static final String USER = "root";
	static final String PASS ="";
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//STEP 3: Open a connection
			System.out.println("Connecting to database");
			conn = DriverManager.getConnection(DB_URL,"root","");
			
			//STEP 4: Execute a query
			System.out.println("Creating statement");
			stmt = conn.createStatement();
			
			System.out.println("Creating table in given database");
			
			String sql = "CREATE TABLE REGISTRATION" +
			              "(id INT not NULL," +
					      "first VARCHAR(255)," +
			              "last VARCHAR(255)," +
					      "age INT, "+
			              "PRIMARY KEY(id))";
			
			stmt.executeUpdate(sql);
			
			System.out.println("Created registration table in the database");
			// STEP 6: Clean-up environment
			
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e) {
			//Handle errors for class.forName
			e.printStackTrace();
		}finally {
			//finally block used to close resources
			try {
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2) {
				
			}//nothing we can do
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}//end finally try
		}//end try
		System.out.println("Goodbye!");
	}//end main

}

