package com.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleDataSource{
	
	String url = "jdbc:oracle:thin:@//localhost:1521/orcl";
    String username = "anonymous";
    String password = "admin";
    Connection cnx;
    
    public OracleDataSource() {
    }
    
    public Connection getConnection() {
    	try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cnx = DriverManager.getConnection(url, username, password);
        	System.out.println("cnx bien etablie");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    	return cnx;
    }
}
