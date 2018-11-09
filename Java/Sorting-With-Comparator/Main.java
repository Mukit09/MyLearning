package com.mukit.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		
		// sort with name, if two have same name, then descending order of age
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
					return o2.getAge() - o1.getAge();
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		});
		
		// Another way, more concise
	//	Collections.sort(persons, Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));
		
		// if one field need to be reversed
		Collections.sort(persons, Comparator.comparing(Person::getFirstName)
				.thenComparing(
						Comparator.comparing(Person::getAge).reversed()
						));
		
		// Another way, Lambda Expression
		Comparator<Person> compareByFirstName = (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName());
		Comparator<Person> compareByAge = (o1, o2) -> o1.getAge() - o2.getAge();
		Comparator<Person> compareByEmailId = (o1, o2) -> o1.getMailId().compareTo(o2.getMailId());
		
		Collections.sort(persons, compareByFirstName
				.thenComparing(compareByAge.reversed())
				.thenComparing(compareByEmailId));
		
		for (Person person : persons) {
			System.out.println(person.getFirstName() + " " + person.getMailId() + " " + person.getAge());
		}
	}
}
