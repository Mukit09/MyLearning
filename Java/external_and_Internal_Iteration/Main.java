package com.mukit.external_and_Internal_Iteration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class Person {
	
	public String firstName;
	public String lastName;
	public String mailId;
	public String jobTitle;
	public int age;
	
	public String getFirstName() {
		return firstName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Person(String firstName, String lastName, String mailId, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.age = age;
	}
}

public class Main {

	public static void main(String[] args) {
		
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Mukit", "Chy", "mukit@gmail.com", 28));
		persons.add(new Person("Rahat", "Samit", "rahat@gmail.com", 28));
		persons.add(new Person("Naime", "Hassan", "naime@gmail.com", 30));
		persons.add(new Person("Raju", "Pal", "raju@gmail.com", 34));
		
		// external iteration with forEach
		for (Person person : persons) {
			
			if(person.getJobTitle().contains("Software")) {
				sendMail(person.getMailId());
			}
		}
		
		// external iteration with iterator
		Iterator<Person> it = persons.iterator();
		while(it.hasNext()) {
			Person person = it.next();
			if(person.getJobTitle().contains("Software")) {
				sendMail(person.getMailId());
			}
		}
		
		// internal iteration using lambda expression
		persons.forEach(person -> {
			
			if(person.getJobTitle().contains("Software")) {
				sendMail(person.getMailId());
			}
		});
	}

	private static void sendMail(String mailId) {
		
	}
}
