package com.company;

/**
 * Created by sega on 11.04.2015.
 */
public class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
        this(10,"New Name");
    }

    @Override
    public int compareTo(Person o) {
        if(this.age==o.age) {
            return 0;
        } else if (this.age > o.age) {
                return 1;
        } else {
            return -1;
        }
    }
}
