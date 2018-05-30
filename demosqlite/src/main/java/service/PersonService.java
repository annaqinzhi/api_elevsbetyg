package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import model.Person;
import sqlite.DeleteData;
import sqlite.InsertData;
import sqlite.SelectData;
import sqlite.UpdateData;

@Service
public class PersonService {
	List<Person> persons=new ArrayList<>();
	
	public List<Person> getAll(){
		getPersons();
		System.out.println("getAll(): persons "+persons);
		return persons;
	}

	public Person getPersonById(String id) {
		getPersons();
		return persons.stream().filter(p->p.getId().equals(id)).findFirst().get();
	}
	
	public Person getPersonByFirstName(String text) {
		getPersons();
		return persons.stream().filter(p->p.getFirstName().toLowerCase().contains(text)).findFirst().get();
	}
	

	public void addPerson(Person person) {
		getPersons();
		persons.add(person);
		
		System.out.println("addPerson(): "+person.getFirstName()+person.getLastName()+person.getBetyg());
		InsertData ind=new InsertData();
		ind.insert(person.getId(), person.getFirstName(), person.getLastName(), person.getBetyg());	
	}

	public void updatePerson(String id, Person person) {
		for (int i=0; i<persons.size(); i++) {
			Person p=persons.get(i);
			if(p.getId().equals(id)) {
				persons.set(i, person);
				
				UpdateData updateData=new UpdateData();
				updateData.update(person.getId(), person.getFirstName(), person.getLastName(), person.getBetyg());
				return;
			}
		}
		
	}

	public void deletePerson(String id) {
		persons.removeIf(p-> p.getId().equals(id));
		
		DeleteData deleteData=new DeleteData();
		deleteData.delete(Integer.parseInt(id));
	}
	
	public void deleteAll() {
		persons.clear();
		
		DeleteData deleteData=new DeleteData();
		deleteData.deleteAll();
	}
	
	public void getPersons() {
		
		createNewTable();
		
		SelectData sd = new SelectData();
		persons=(List<Person>) sd.selectAll();
		
		System.out.println("getPersons(): persons "+persons);
	}
	
	public static void createNewTable() {
        
        String url = "jdbc:sqlite:/Users/annaqin/Desktop/AnnaWork/sqlite/db/persons.db";
        String sql = "CREATE TABLE IF NOT EXISTS persons (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	firstname text NOT NULL,\n"
                + "	lastname text NOT NULL,\n"
                + "	betyg text NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
                stmt.execute(sql);
                
                stmt.close();
                conn.commit();
                conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
		
}
