package com.mukit.stream;

public class Person {
    private String name;
    private String jobTitle;
    private String mailId;
    private int age;

    public Person(String name, String jobTitle, String mailId, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.mailId = mailId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getMailId() {
        return mailId;
    }

    public int getAge() {
        return age;
    }
}
