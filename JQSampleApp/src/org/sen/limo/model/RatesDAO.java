package org.sen.limo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sen.limo.domain.Rates;
import org.sen.limo.domain.Request;

public class RatesDAO {
    
    public RatesDAO() {
        super();
        System.out.println("RatesDAO() ctor called. ");        
    }
    
    public List<Rates> retriveRates() {
    	System.out.println("retriveRates() invoked. ");
        List<Rates> ress = new ArrayList<Rates>();
        Connection conn = null;
   	 	Statement stmt =null;
        try {
            conn = DBConnection.getDBConnection();
            stmt = conn.createStatement();
            String sql = "select * from limo.Rates";

            System.out.println("SQL : "+sql);
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();           
            
            while (rs.next()) {
                Rates res = new Rates();                
                res.fromCity= rs.getString("fromcity");
                res.toCity = rs.getString("tocity");
                res.amount = rs.getString("amount");
                ress.add(res);
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

        return ress;
    }    
    
   
    public static void main(String[] args) {
        RatesDAO dao = new RatesDAO();
        Request re = new Request();

    }

}
