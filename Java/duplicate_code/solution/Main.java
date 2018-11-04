package com.mukit.duplicate_code.solution;


import java.util.ArrayList;
import java.util.List;

import com.mukit.duplicate_code.solution.Person.Gender;

public class Main {
	
	interface Filterable {
		
		boolean test(Person person);
	}
	
	private static int countPerson(List<Person> persons, Filterable filterable) {
		
		List<Person> requiredPersons = new ArrayList<>();
		
		for(Person person : persons) {
			
			if(filterable.test(person)) {
				requiredPersons.add(person);
			}
		}
		
		System.out.println("Required Person Size: " + requiredPersons.size());
		return requiredPersons.size();
	}

	public static void main(String[] args) {
		
		List<Person> persons = Person.createPersons();
		
		int maleNumber = countPerson(persons, new Filterable() {
			
			@Override
			public boolean test(Person person) {
				return person.getGender() == Person.Gender.MALE;
			}
		});
		System.out.println(maleNumber);
		
		/*// using lambda expression 
		Filterable maleOnly = person -> person.getGender() == Person.Gender.MALE;
		maleNumber = countPerson(persons, maleOnly);
		System.out.println(maleNumber);*/
		
		// Now 1 year later I need to know about female, then I did this
		
		int femaleNumber = countPerson(persons, new Filterable() {
			
			@Override
			public boolean test(Person person) {
				return person.getGender() == Person.Gender.FEMALE;
			}
		});
		System.out.println(femaleNumber);
		
		// So I don't need to write duplicate code
	}
}

