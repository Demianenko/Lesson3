package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
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
        /*
        testMyLinkedList(new MyLinkedList());
        System.out.println("---------------------------------------------------------------");
        testMyLinkedList(new MyArrayList());
        */


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
