package org.sen.limo.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import com.google.appengine.api.*;
//import com.google.cloud.sql.jdbc.internal.*;
//import com.google.cloud.sql.jdbc.*;
//import com.google.cloud.sql.*;
//import com.google.cloud.*;
import java.sql.*;
import com.google.appengine.api.utils.SystemProperty;


public class DBConnection {

    public DBConnection() {
    }
    
    public static Connection getDBConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
        	Class.forName("com.google.appengine.api.rdbms.AppEngineDriver");        	
        } catch (ClassNotFoundException e) {
                System.out.println("Where is your MySQL JDBC Driver?");
                e.printStackTrace();
                return null;
        }        
        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;        
        try {
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/limo","root", "password");
        	//connection = DriverManager.getConnection("jdbc:google:rdbms://localhost:3306/limo","root", "password");
        	connection = DriverManager.getConnection("jdbc:google:rdbms://ablimoservices:ablimoservicesdb/limo");
        } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return null;
        }    
        if (connection != null) {
                System.out.println("You made it, take control your database now!");
        } else {
                System.out.println("Failed to make connection!");
        }
        return connection;
    }

    public static void main(String[] argv) {
 
	System.out.println("-------- MySQL JDBC Connection Testing ------------");
 
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		System.out.println("Where is your MySQL JDBC Driver?");
		e.printStackTrace();
		return;
	}
 
	System.out.println("MySQL JDBC Driver Registered!");
	Connection connection = null;
 
	try {
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3307/limo","root", "password");
 
	} catch (SQLException e) {
		System.out.println("Connection Failed! Check output console");
		e.printStackTrace();
		return;
	}
 
	if (connection != null) {
		System.out.println("You made it, take control your database now!");
	} else {
		System.out.println("Failed to make connection!");
	}
  }
}
