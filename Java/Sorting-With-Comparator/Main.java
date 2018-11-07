package com.mukit.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Person> persons = new ArrayList<>();
		persons.add(new Person(28, "Mukit", "Chy", "mukit@ssd-tech.com"));
		persons.add(new Person(34, "raju", "pal", "rajib@ssd-tech.com"));
		persons.add(new Person(27, "Mukit", "Hassan", "naime@ssd-tech.com"));
		persons.add(new Person(28, "Rahat", "Samit", "samit@ssd-tech.com"));
		
		// using Anonymous Inner Class
		Collections.sort(persons, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				
				if(o1.getFirstName().equals(o2.getFirstName()))
					return o1.getAge() - o2.getAge();
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		
		// Another way, more concise
		Collections.sort(persons, Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));
		
		for (Person person : persons) {
			System.out.println(person.getFirstName() + " " + person.getMailId() + " " + person.getAge());
		}
	}
}
