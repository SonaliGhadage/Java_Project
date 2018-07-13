package MyProj.identity.mgmt.datamodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import MyProj.identity.mgmt.datamodel.Identity;
public class IdentityDAO {

 

// This DAO class provides CRUD database operations for the table Identities
 // in the database.
 
    private String jdbcURL;
    private String jdbcUsername; 
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public IdentityDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
        	try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }

            jdbcConnection = DriverManager.getConnection(
            		jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean loginIdentity(Identity bean) throws SQLException {
    	boolean status = false;  
    	String sql =  "select * from Admin where usr_name=? and pass=?";  
    	connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
         
    	
    statement.setString(1,bean.getUsr_name());
        statement.setString(2,bean.getPass());
         
          //connect to DB 
        ResultSet rs = statement.executeQuery();
        status=rs.next();
    		              
        return status;
    }
	    
      
    
    public boolean insertIdentity(Identity iden) throws SQLException {
        String sql = "INSERT INTO IDEN (USER_ID, NAME, EMAIL_ID) VALUES (?, ?, ?)";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, iden.getUSER_ID());
        statement.setString(2, iden.getNAME());
        statement.setString(3, iden.getEMAIL_ID());
         
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

     
    public List<Identity> listAllIdentites() throws SQLException {
        List<Identity> listIdentity = new ArrayList<>();
        
        //*****Listing*****//  
        
        String sql = "SELECT * FROM IDEN ORDER BY USER_ID ASC";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int id = resultSet.getInt("USER_ID");
            String Name = resultSet.getString("NAME");
            String Email_id = resultSet.getString("EMAIL_ID");
             
            Identity iden = new Identity(id, Name, Email_id);
            listIdentity.add(iden);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listIdentity;
    }
    
    public Identity searchIdentity(int USER_ID) throws SQLException {
	  Identity crite1 = null;
          String sql = "SELECT USER_ID, NAME, EMAIL_ID from IDEN where USER_ID = ?";
		  connect();
			 
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		     statement.setInt(1, USER_ID);
		     ResultSet rs = statement.executeQuery();
			 if (rs.next()) {
				 int USER_ID2 = rs.getInt("USER_ID");
				 String NAME = rs.getString("NAME");
				 String EMAIL_ID = rs.getString("EMAIL_ID");
				 crite1 = new Identity(USER_ID2, NAME, EMAIL_ID);
			}
			
			rs.close();
	        statement.close();
	         
	        disconnect();
	        return crite1;
	}

     
    public boolean deleteIdentity(Identity identity) throws SQLException {
        
        String sql = "DELETE FROM IDEN where USER_ID = ?";
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, identity.getUSER_ID());
         
        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        
        return rowDeleted;     
    }
     
    public boolean updateIdentity(Identity identity) throws SQLException {
        String sql = "UPDATE IDEN SET NAME = ?, EMAIL_ID = ?";
        sql += " WHERE USER_ID = ?";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, identity.getNAME());
        statement.setString(2, identity.getEMAIL_ID());
        statement.setInt(3, identity.getUSER_ID());
        
         
        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;     
    }
     
    public Identity getIdentity(int USER_ID) throws SQLException {
        Identity identity = null;
        String sql = "SELECT * FROM IDEN WHERE USER_ID = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, USER_ID);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {

            int USER_ID1 = resultSet.getInt("USER_ID");
            String NAME = resultSet.getString("NAME");
            String EMAIL_ID = resultSet.getString("EMAIL_ID");
             
            identity = new Identity(USER_ID1, NAME, EMAIL_ID);
        }
         
        resultSet.close();
        statement.close();
         
        return identity;
    }
}