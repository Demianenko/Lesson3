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
    public void add(Object o) {
        if(next == null) {
            next = new Node(o,null);
        } else {
            next.add(o);
        }
    }

    public int size(){
        if(next == null) {
        return +1;
        } else {
        return 1 + next.size();
        }
    }

    public Object get(int i) {
        if(i==0) {
            return value;
        } else {
            return next.get(i-1);
        }
    }

    public int indexOf (Object o) {
        if(value == o) {
            return 0;
        }
        else {
            return 1+next.indexOf(o);
        }
    }

    public boolean contains(Object o) {
        if(next!=null) {
            if (value == o) {
                return true;
            } else {
                return next.contains(o);
            }
        }
    return false;
    }

    public void put(int i, Object o) {
        if(i == 0) {
            value=o;
        } else {
            next.put(i-1,o);
        }
    }

    public void insert(int i, Object o) {
        if(next==null) {
            add(o);
        } else {
            if(i==0) {
                Node temp = new Node(value,next);
                this.value = o;
                this.next=temp;
            } else {
                next.insert(i-1,o);
            }
        }

    }

    public Object remove(int i) {
        if(next==null) {
            Object temp = value;
            clear();
            return temp;
        } else {
            if(next.next==null){
                Object temp = next.value;
                this.next = null;
                return temp;
            } else {
                if(i==0) {
                    Object temp = value;
                    this.value = next.value;
                    this.next = next.next;
                    return temp;
                } else {
                    return next.remove(i-1);
                }
            }
        }

    }

    public void clear() {
        value = null;
        next = null;
    }
/*
    public String toString(){
        return value + ","+(next == null ? "null" : next.toString());
    }*/
    public String toString(){
        /*if(value==null) {
            return "null";
        }*/
        if(next == null) {
            return value+","+"null";
        } else {
            return value+","+next.toString();
        }
    }
}
