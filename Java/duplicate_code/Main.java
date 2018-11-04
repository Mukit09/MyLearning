package com.mukit.duplicate_code;

import java.util.ArrayList;
import java.util.List;

import com.mukit.duplicate_code.Person.Gender;

public class Main {

	public static void main(String[] args) {
		
		List<Person> persons = Person.createPersons();
		int maleNumber = countMalePersons(persons);
		
		// Now 1 year later I need to know about female, then I did this
		
		int femaleNumber = countFemalePerson(persons);
		
		// So it is duplicate code as only one line is change 
		// between these two methods
	}

	private static int countFemalePerson(List<Person> persons) {
		List<Person> femalePersons = new ArrayList<>();
		
		for(Person person : persons) {
			
			if(person.getGender() == Gender.FEMALE) {
				femalePersons.add(person);
			}
		}
		
		System.out.println("Female Person Size: " + femalePersons.size());
		return femalePersons.size();
	}

	private static int countMalePersons(List<Person> persons) {
		List<Person> malePersons = new ArrayList<>();
		
		for(Person person : persons) {
			
			if(person.getGender() == Gender.MALE) {
				malePersons.add(person);
			}
		}
		System.out.println("Male Person Size: " + malePersons.size());
		return malePersons.size();
	}

}
