package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        MyTreeSet treeSet = new MyTreeSet();
        MyHashSet set = new MyHashSet();
        Person first = new Person(1,"First");
        Person second = new Person(2, "Second");
        MyTreeSet<Person> treeSet1 = new MyTreeSet<Person>();
        treeSet.add(first);
        treeSet.add(second);



    }

    public static void testMyHashSet(MyHashSet set) {
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
        System.out.println(set.size());

        System.out.println(set.add(2));
        System.out.println(set);
        System.out.println(set.add(0));
        System.out.println(set);
        System.out.println(set.add(3));
        System.out.println(set);
        System.out.println(set.add(5));
        System.out.println(set);
        System.out.println(set.add(0));
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.add(5));
        System.out.println(set);
        MyIterator iterator = set.iterator();
        System.out.println("-----------Iterator-----------");
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(set);

    }
    public static void testMyLinkedList(MyList list) {
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.add(0);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.add(1);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.add("h");
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.insert(0,5);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(1);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(0);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(1);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(0);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
    }

}
