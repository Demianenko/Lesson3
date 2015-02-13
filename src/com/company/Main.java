package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
      //  testMyLinkedList(list);
        IterList iList = new IterList();
        Node tail = new Node(0, new Node(1, new Node(2, new Node(3, null))));
        iList.first = tail;
        System.out.println(iList);
        System.out.println(iList.isEmpty());

        iList.add(4);
        System.out.println(iList + "    " + iList.size());
        System.out.println(iList.get(4));
        System.out.println(iList.indexOf(4));
        System.out.println(iList.contains(5));
        iList.put(0, "a");
        iList.put(4,"b");
        System.out.println(iList+"    "+iList.size());
        iList.insert(0,"A");
        System.out.println(iList+"    "+iList.size());
        iList.insert(6,"B");
        System.out.println(iList+"    "+iList.size());
        iList.remove(0);
        System.out.println(iList+"    "+iList.size());
        iList.remove(5);
        System.out.println(iList+"    "+iList.size());



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
