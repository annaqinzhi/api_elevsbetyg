package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
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
	
	public void update(String id, String firstname, String lastname, String betyg) {
        String sql = "UPDATE persons SET firstname = ?,"
                + "lastname = ?, "
                + "betyg = ?"
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, betyg);
            pstmt.setString(4, id);
            // update 
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
