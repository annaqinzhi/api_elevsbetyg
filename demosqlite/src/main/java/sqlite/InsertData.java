package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/Users/annaqin/Desktop/AnnaWork/sqlite/db/persons.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	public void insert(String firstname, String lastname, String betyg) {
        String sql = "INSERT INTO persons(firstname,lastname,betyg) VALUES(?,?,?)";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, betyg);
            pstmt.executeUpdate();
           
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void insert(String id, String firstname, String lastname, String betyg) {
        String sql = "INSERT INTO persons(id, firstname,lastname,betyg) VALUES(?,?,?,?)";
 
        try (Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	pstmt.setString(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, betyg);
            pstmt.executeUpdate();
           
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
}
