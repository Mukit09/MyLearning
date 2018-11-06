package com.mukit.comparable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(28, "Mukit", "Chy", "mukit@ssd-tech.com"));
		persons.add(new Person(34, "raju", "pal", "rajib@ssd-tech.com"));
		persons.add(new Person(30, "Naime", "Hassan", "naime@ssd-tech.com"));
		persons.add(new Person(28, "Rahat", "Samit", "samit@ssd-tech.com"));
		
		Collections.sort(persons);
		
		for (Person person : persons) {
			System.out.println(person.getFirstName() + " " + person.getMailId() + " " + person.getAge());
		}
	}
}
