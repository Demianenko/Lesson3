package com.company;


/**
 * Created by sega on 11.04.2015.
 */
public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
        this(10,"New Name");
    }

    public static class PersonComparator<E> implements MyComparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if (p1.age < p2.age) {
                System.out.println("p1 < p2");
                return  -1;
            } else if (p1.age>p2.age) {
                System.out.println("p1 > p2");
                return 1;
            } else {
                System.out.println("p1 = p2");
                return  0;
            }
        }
    }


}
