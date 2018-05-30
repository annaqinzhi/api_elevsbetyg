package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Person;

public class SelectData {
	
	private Connection connect() {
       
        String url = "jdbc:sqlite:/Users/annaqin/Desktop/AnnaWork/sqlite/db/persons.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	
	
	
	public List<Person> selectAll(){
		
		List<Person> pl=new ArrayList<>();
	
		
        String sql = "SELECT id, firstname, lastname, betyg FROM persons";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
         
             while (rs.next()) {
            	    Person p=new Person();
            	    String id=rs.getString("id");
            	    String firstname=rs.getString("firstname");
            	    String lastname=rs.getString("lastname");
            	    String betyg=rs.getString("betyg");
                    p.setId(id);
                    p.setFirstName(firstname);
                    p.setLastName(lastname);
                    p.setBetyg(betyg);
                    pl.add(p);
                    System.out.println("select "+id+firstname+lastname+betyg);
                    System.out.println("this p is  "+p.getId()+p.getFirstName()+p.getLastName());
                    System.out.println("pl "+pl);
             }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("select "+pl.size());
          return pl;
          
    }
	
}
