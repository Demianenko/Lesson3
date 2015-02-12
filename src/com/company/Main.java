package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(0);
        list.add(1);
        list.add("g");
        System.out.println(list);
        System.out.println(list.size());

    }
}
