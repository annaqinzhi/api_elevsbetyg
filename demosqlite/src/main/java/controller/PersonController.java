package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Person;
import service.PersonService;

@RestController
public class PersonController {
   @Autowired
   PersonService ps;
   
   @RequestMapping(value="/persons", method=RequestMethod.GET)
   public List<Person> getAll() {
	   return ps.getAll();
   }
   
   @RequestMapping(value="/persons", method=RequestMethod.POST)
   public void addPerson(@RequestBody Person person) {
	   ps.addPerson(person);
	   
   }
   
   @RequestMapping(value="/persons/{id}", method=RequestMethod.GET)
   public Person getPersonById(@PathVariable("id") String id) {
	   return ps.getPersonById(id);
   }
   
   @RequestMapping(value="/persons/{id}", method=RequestMethod.PUT)
   public void updatePerson(@RequestBody Person person, @PathVariable("id") String id) {
	   ps.updatePerson(id, person);
	   
   }
   
   @RequestMapping(value="/persons/{id}", method=RequestMethod.DELETE)
   public void deletePerson(@PathVariable("id") String id) {
	   ps.deletePerson(id);
	   
   }
   
   
   @RequestMapping(value="/persons/all", method=RequestMethod.DELETE)
   public void deleteAll() {
	   ps.deleteAll();
	   
   }
	   
   
}
