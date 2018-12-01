package com.mukit.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamDemo {
    private static List<Person> getPersonList() {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Mukit Chowdhury", "Software Engineer",
                "mukit@ssd-tech.com", 28));
        persons.add(new Person("abc Chowdhury", "Businessman",
                "abc@ssd-tech.com", 29));
        persons.add(new Person("Shamol Roy", "Shopkeeper",
                "shamol@ssd-tech.com", 27));
        persons.add(new Person("Yousuf Miah", "Banker",
                "yousuf@ssd-tech.com", 20));
        persons.add(new Person("Abu Bakkar", "Software Engineer",
                "abu@gmail.com", 31));
        persons.add(new Person("Shuvo Mahmud", "Software Engineer",
                "shuvo@ssd-tech.com", 28));
        persons.add(new Person("Rahat Hossain", "Banker",
                "rahat@yahoo.com", 28));
        return persons;
    }

    public static void main(String[] args) {
        List<Person> persons = getPersonList();

        // get stream of person whose age greater than 30 and print
        // those person's names
        System.out.println("get stream of person whose age greater than 30 and print.......");
        persons.stream()
                .filter(person -> person.getAge() > 30)
                .filter(person -> person.getJobTitle().toLowerCase().contains("software"))
                .forEach(person -> System.out.println(person.getName()));

        // get stream of person whose age greater than 30 and count
        // those person
        System.out.println("get stream of person whose age greater than 30 and count.......");
        long count = persons.stream()
                .filter(person -> person.getAge() > 30)
                .filter(person -> person.getJobTitle().toLowerCase().contains("software"))
                .count();
        System.out.println(count);

        // map to convert Stream to other type
        System.out.println("map to convert Stream to other type.......");
        persons.stream()
                .filter(person -> person.getJobTitle().toLowerCase().contains("software"))
                .map(person -> person.getName())
                .forEach(name -> System.out.println(name));

        // average age of all person
        System.out.println("average age of all person.......");
        OptionalDouble average = persons.stream()
                .mapToInt(person -> person.getAge())
                .average();
        if(average.isPresent()) {
            System.out.println(average.getAsDouble());
        }

        // average age of all person in stream function
        System.out.println("average age of all person in stream function.......");
        persons.stream()
                .mapToInt(person -> person.getAge())
                .average()
                .ifPresent(doubleAverage -> System.out.println(doubleAverage));

        // give list of person who are older than 29 and are software engineer
        System.out.println("give list of person who are older than 29 and are software engineer.......");
        List<Person> softwarePeople = persons.stream()
                .filter(person -> person.getAge() > 27)
                .filter(person -> person.getJobTitle().toLowerCase().contains("software"))
                .collect(Collectors.toList());

        for (Person softwarePerson : softwarePeople) {
            System.out.println(softwarePerson.getName() + " " + softwarePerson.getJobTitle() + " " + softwarePerson.getAge());
        }

        // list all the name comma separated
        System.out.println("list all the name comma separated.......");
        String joinedString = persons.stream()
                .map(person -> person.getName() + " " + person.getAge())
                .collect(Collectors.joining(", "));
        System.out.println(joinedString);

        // list all the distinct job title comma separated
        System.out.println("list all the distinct job title comma separated.......");
        String joinedString1 = persons.stream()
                .map(person -> person.getJobTitle())
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(joinedString1);

        // Count stream result of person older than 30
        System.out.println("Count stream result of person older than 30.......");
        long count1 = persons.stream()
                .filter(person -> person.getAge() > 30)
                .count();
        System.out.println(count1);

        // use of dropwhile
        System.out.println("use of dropwhile.......");
        // drop as long as possible, if condition is false
        // then start taking
        IntStream.range(1, 10)
                .dropWhile(value -> value < 4)
                .forEach(value -> System.out.println(value));

        // use of takewhile
        System.out.println("use of takewhile");
        // take as long as possible, if condition is false
        // then break the loop, as you aren't taking anymore
        IntStream.range(1, 10)
                .takeWhile(value -> value < 4)
                .forEach(value -> System.out.println(value));

        // sorting with stream
        System.out.println("sorting with stream.......");
        List<Person> collect = persons.stream()
                .sorted(new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getAge() - o2.getAge();
                    }
                })
                .collect(Collectors.toList());

        for (Person person : collect) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        // Another way of sorting
        System.out.println("Another way of sorting.......");
        persons.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        for (Person person : collect) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        // using limit in stream
        System.out.println("using limit in stream.......");
        persons.stream()
                .limit(5)
                .forEach(person -> System.out.println(person.getName()));

        int core = Runtime.getRuntime().availableProcessors();
        System.out.println("Total core are: " + core);
        // send mail to person with parallel stream
        persons.stream()
                .parallel()
                .forEach(person -> sendMail(person.getMailId()));

        // statistics using stream
        DoubleStream doubleStream = persons.stream()
                .mapToDouble(person -> person.getAge());
        DoubleSummaryStatistics doubleSummaryStatistics = doubleStream.summaryStatistics();
        System.out.println("max: " + doubleSummaryStatistics.getMax() + ", average: " + doubleSummaryStatistics.getAverage()
                + ", count: " + doubleSummaryStatistics.getCount());
    }

    private static void sendMail(String mailId) {
        try {
            System.out.println("Sending mail to " + mailId + " from " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}