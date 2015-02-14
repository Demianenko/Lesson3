package com.company;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
      //  testMyLinkedList(list);
        RecList rList = new RecList();
        Node tail = new Node(0, new Node(1, new Node(2, new Node(3, null))));

        System.out.println(rList.size());
        System.out.println(rList);
        System.out.println(rList.isEmpty());
        rList.insert(0, 0);
        System.out.println(rList);
        System.out.println(rList.remove(0));
        System.out.println(rList);
        System.out.println(rList.isEmpty());
        System.out.println(rList.contains(0));
        rList.add(0);
        rList.add(1);
        rList.add(2);
        rList.add(3);
        rList.add(4);
        System.out.println(rList);
        System.out.println(rList.isEmpty());
        System.out.println(rList + "    " + rList.size());
        System.out.println(rList.get(4));
        System.out.println(rList.indexOf(4));
        System.out.println(rList.contains(5));
        rList.put(0, "a");
        rList.put(4,"b");
        System.out.println(rList+"    "+rList.size());
        rList.insert(0,"A");
        System.out.println(rList+"    "+rList.size());
        rList.insert(6,"B");
        System.out.println(rList+"    "+rList.size());
        rList.remove(0);
        System.out.println(rList+"    "+rList.size());
        rList.remove(5);
        System.out.println(rList+"    "+rList.size());



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
