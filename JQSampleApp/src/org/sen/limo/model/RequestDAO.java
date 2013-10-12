package org.sen.limo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.sen.limo.domain.Request;

public class RequestDAO {
    
    public RequestDAO() {
        super();
    }
    /**     
     * @see     
     */
    public String insertRequest(Request req) {
        String requestId = "-1";
        Connection conn = null;
   	 	Statement stmt =null;
        try {
            conn = DBConnection.getDBConnection();
            stmt = conn.createStatement();
            String sql = "insert into limo.Request(typeOfLimo," + 
            "startDate,endDate,startTime,endTime,passengers,yourName,contactNumber,email,occasion,needADrink,status) values(" +
            "'"+req.typeOfLimo+"',\n" + 
            "'"+req.startDate+"',\n" + 
            "'"+req.endDate+"',\n" + 
            "'"+req.startTime+"',\n" + 
            "'"+req.endTime+"',\n" + 
            "'"+req.passengers+"',\n" + 
            "'"+req.yourName+"',\n" + 
            "'"+req.contactNumber+"',\n" + 
            "'"+req.email+"',\n" + 
            "'"+req.occasion+"',\n" + 
            "'"+req.needADrink+"',\n" + 
            "'"+req.status+"'\n" + 
            ")\n";
            System.out.println("SQL : "+sql);
            int res = stmt.executeUpdate(sql);
            if(res != -1) {
                Statement stmt1 = conn.createStatement();
                sql = "select max(ID) AS ID from limo.Request";
                ResultSet rs = stmt1.executeQuery(sql);
                while (rs.next()) {
                    System.out.println("8888888");
                    requestId = rs.getString("ID");
                    System.out.println("requestId -: "+requestId);
                }
            }
            System.out.println(res);
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
        return requestId;
    }    
    public List<Request> retrivePendingRequest() {
        List<Request> ress = new ArrayList<Request>();
        Connection conn = null;
   	 	Statement stmt =null;
        try {
            conn = DBConnection.getDBConnection();
            stmt = conn.createStatement();
            String sql = "select * from limo.Request";

            System.out.println("SQL : "+sql);
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
           
            while (rs.next()) {
                Request res = new Request();
                res.ID = rs.getString("ID");
                res.typeOfLimo = rs.getString("typeOfLimo");
                res.startDate = rs.getString("startDate");
                res.endDate = rs.getString("endDate");
                res.startTime = rs.getString("startTime");
                res.endTime = rs.getString("endTime");
                res.yourName = rs.getString("yourName");
                res.contactNumber = rs.getString("contactNumber");
                res.email = rs.getString("email");
                res.occasion = rs.getString("occasion");
                res.needADrink = rs.getString("needADrink");
                res.status = rs.getString("status");
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
    
    public void updateRequestStatus(String newStatus, String id) {
    	 Connection conn = null;
    	 Statement stmt =null;
        try {
            conn = DBConnection.getDBConnection();
            stmt = conn.createStatement();
            String sql = "update limo.Request set status = '"+newStatus+"' where ID = '"+id+"'";
            System.out.println("SQL : "+sql);
            int re = stmt.executeUpdate(sql);
           
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
        RequestDAO dao = new RequestDAO();
        Request re = new Request();
        dao.insertRequest(re);
        //dao.retrivePendingRequest();
    }

}
