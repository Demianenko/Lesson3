package com.company;

import com.company.More.RecList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(0);
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println("_______________________________________");
        MyIterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }
        MyIterator it1 = list.iterator();
        while (it1.hasNext()) {
            it1.next();
            list.put(0,5);
        }
        System.out.println("__________________________________________");
        MyIterator it2 = list.iterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
        /*
        MyLinkedList list = new MyLinkedList();
        testMyLinkedList(list);
        MyList rList = new RecList();
        testMyRecList(rList);
        */




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
    public static void testMyRecList(MyList rList) {
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
}
