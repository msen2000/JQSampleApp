package org.sen.limo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDAO {
    public LoginDAO() {
        super();
    }
    
    public void getUser(){
    	 Connection conn = null;
    	 Statement stmt =null;
        try {
            conn = DBConnection.getDBConnection();
            stmt = conn.createStatement();
            String sql = "select UserName, Password from limo.Login where UserName = 'admin'";
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                String name = rs.getString("UserName");
                String pass = rs.getString("Password");
                System.out.println(name+"- "+pass);
            }
        }catch(Exception e) {
            e.printStackTrace();            
        } finally {
        	try {
	        	if(conn != null) {
	        		conn.close();
	        	}
	        	if(stmt != null) {
	        		stmt.close();        		
	        	}
        	} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    } 
    public static void main(String[] args) {
        LoginDAO dao = new LoginDAO();
        dao.getUser();
    }
}
