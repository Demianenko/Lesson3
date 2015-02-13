package com.company;

/**
 * Created by sega on 13.02.2015.
 */
public class IterList {
    public Node first;
    public String toString() {
        return first.toString();
    }
    public void add(Object o) {
        first.add(o);
    }
    public int size() {
        return first.size();
    }
    public boolean isEmpty() {
        return (first.size()==0);
    }
    public Object get (int i) {
        return first.get(i);
    }
    public int indexOf(Object o) {
        return first.indexOf(o);
    }
    public boolean contains(Object o) {
        return first.contains(o);
    }
    public void put(int i, Object o) {
        first.put(i,o);
    }
    public void insert(int i, Object o) {
        first.insert(i,o);
    }
    public Object remove(int i) {
        return first.remove(i);
    }
    public void clear() {
        first.clear();
    }
}
