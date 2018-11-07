package com.mukit.comparator;

public class Person {

	private int age;
	private String firstName;
	private String lastName;
	private String mailId;
	
	public Person(int age, String firstName, String lastName, String mailId) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFirstName() {
		return firstName;
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
}
