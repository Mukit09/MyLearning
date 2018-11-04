package com.mukit.lambda;

import java.util.List;

public class Main {
	
	interface Filterable {
		
		boolean ageChecker(Person person);
	}
	
	private static int countPerson(List<Person> persons, Filterable filterable) {
		
		int personCount = 0;
		for (Person person : persons) {
			
			if(filterable.ageChecker(person)) {
				
				personCount++;
				System.out.println(person.getName() + " is " + person.getAge() + " years old.");
			}
		}
		return personCount;
	}

	public static void main(String[] args) {
		
		List<Person> persons = Person.createPersons();
		
		// Lambda Expression for get person of 
		// age 45 - 60
		
		Filterable filterable = person -> person.getAge() >= 45 && person.getAge() <= 60;
		int personCount = countPerson(persons, filterable);
		System.out.println(personCount);
		
	}
}
