package com.mukit.lambda;

import java.util.ArrayList;
import java.util.List;

public class Person {

	enum Gender {
		MALE, FEMALE;
	}
	private int age;
	private String name;
	private Gender gender;
	
	public Person(int age, String name, Gender gender) {
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public static List<Person> createPersons() {
		
		List<Person> list = new ArrayList<>();
		list.add(new Person(45, "Mukit", Gender.MALE));
		list.add(new Person(30, "Anik", Gender.MALE));
		list.add(new Person(55, "Wonder Women", Gender.FEMALE));
		return list;
	}
}
