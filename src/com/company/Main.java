package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        testMyLinkedList(list);
        IterList iList = new IterList();
        Node tail = new Node(0, new Node(1, new Node(2, new Node(3, null))));
        iList.first = tail;
        System.out.println(iList);

    }
    public static void testMyLinkedList(MyLinkedList list) {
        System.out.println(list+"  "+list.size());

        list.add(0);
        System.out.println(list+"  "+list.size());

        list.add(1);
        System.out.println(list+"  "+list.size());

        list.add("h");
        System.out.println(list+"  "+list.size());

        list.insert(0,5);
        System.out.println(list+"  "+list.size());

        list.remove(3);
        System.out.println(list+"  "+list.size());

        list.remove(0);
        System.out.println(list+"  "+list.size());

        list.remove(1);
        System.out.println(list+"  "+list.size());

        list.remove(0);
        System.out.println(list+"  "+list.size());

    }
}
