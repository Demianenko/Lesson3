package com.company;

/**
 * Created by sega on 13.02.2015.
 */
public class Node {
    public Object value;
    public Node  next;

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Node(Object value, Node next) {

        this.value = value;
        this.next = next;
    }

    public String toString(){
        return value + ","+(next == null ? "null" : next.toString());
    }
}
