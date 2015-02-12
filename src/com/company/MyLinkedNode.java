package com.company;

/**
 * Created by user on 12.02.2015.
 */
public class MyLinkedNode {
    private Object value;
    private MyLinkedNode next;

    public MyLinkedNode(Object value, MyLinkedNode next) {
        this.value = value;
        this.next = next;
    }

    public Object getValue() {
        return value;
    }

    public MyLinkedNode getNext() {
        return next;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(MyLinkedNode node) {
        this.next = node;
    }
}
