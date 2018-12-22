package com.mukit.stream;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.*;

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

        // multiplication of 7 upto 10 using map and range
        System.out.println("multiplication of 7 upto 10 using map and range.......");
        int table = 7;
        IntStream.range(1, 11)
                .mapToObj(value -> String.format("%d x %d = %d", table, value, value * table))
                .forEach(line -> System.out.println(line));

        // sum using range and sum
        System.out.println("sum using range and map.......");
        long sum = LongStream.range(1, 10)
                .sum();
        System.out.println("Sum is: " + sum);

        //findFirst
        System.out.println("findFirst.......");
        OptionalInt first = IntStream.range(1, 100)
                .filter(value -> value % 5 == 0)
                .map(value -> value * 5)
                .findFirst();
        if(first.isPresent())
            System.out.println(first.getAsInt());

        //findFirst in persons list
        System.out.println("findFirst in persons list.......");
        Optional<Person> first1 = persons.stream()
                .peek(person -> System.out.println("first peek " + person.getName() + " " + person.getAge()))
                .filter(person -> person.getAge() > 28)
                .peek(person -> System.out.println("second peek " + person.getName() + " " + person.getAge()))
                .findFirst();
        if(first1.isPresent()) {
            Person firstPerson = first1.get();
            System.out.println(firstPerson.getName() + " " + firstPerson.getAge());
        }

        //findAny
        System.out.println("findAny.......");
        OptionalInt any = IntStream.range(1, 10)
                .filter(value -> value % 5 == 0)
                .map(value -> value * 5)
                .findAny();
        if(any.isPresent())
            System.out.println(any.getAsInt());

        //using generate
        System.out.println("using generate.......");
        Stream<UUID> generate = Stream.generate(() -> UUID.randomUUID());
        generate.limit(10)
                .forEach(str -> System.out.println(str));

        // Count stream result of person older than 30
        System.out.println("Count stream result of person older than 30.......");
        long count1 = persons.stream()
                .filter(person -> person.getAge() > 30)
                .count();
        System.out.println(count1);

        // use of dropwhile
        System.out.println("use of dropwhile.......");
        // drop till condition is false
        // then start taking
        String collect1 = IntStream.range(1, 10)
                .dropWhile(value -> value < 4)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(", "));
        System.out.println(collect1);

        System.out.println("takeWhile for unordered list......");
        String s1 = IntStream.of(1, 10, 9, 20, 5, 4, 3, 2, 12)
                .dropWhile(i -> i < 12)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(", "));
        System.out.println(s1);

        Stream.of("a", "b", "c", "", "d")
                .dropWhile(s -> !s.isEmpty())
                .forEach(s -> System.out.println(s));

        // use of takewhile
        System.out.println("use of takewhile");
        // take as long as possible, if condition is false
        // then break the loop, as you aren't taking anymore
        String collect2 = IntStream.range(1, 10)
                .takeWhile(value -> value < 4)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(", "));
        System.out.println(collect2);

        String collect3 = IntStream.of(10, 3, 2, 1, 12, 5, 100)
                .takeWhile(i -> i < 7)
                .mapToObj(i -> ((Integer) i).toString())
                .collect(Collectors.joining(", "));
        System.out.println("output found: " + collect3);

        // count frequency of each unique character in a string
        System.out.println("count frequency of each unique character in a string.......");
        String test = "testing";
        LinkedHashMap<String, Long> collect4 = Arrays.stream(test.split(""))
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        System.out.println(collect4);
        // in brief of previous one
        LinkedHashMap<String, Long> collect5 = Arrays.stream(test.split(""))
                .map(s -> s.toLowerCase())
                .collect(Collectors.groupingBy(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s;
                    }
                }, new Supplier<LinkedHashMap<String, Long>>() {
                    @Override
                    public LinkedHashMap<String, Long> get() {
                        return new LinkedHashMap<String, Long>();
                    }
                }, Collectors.counting()));

        // String Length Wise Collect using groupingBy
        System.out.println("String Length Wise Collect using groupingBy.......");
        List<String> strings = List.of("a", "bb", "cc", "ddd");
        LinkedHashMap<Integer, List<String>> lengthWiseCollectAsList = strings.stream()
                .collect(Collectors.groupingBy(String::length, LinkedHashMap::new, Collectors.toList()));
        System.out.println(lengthWiseCollectAsList);

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