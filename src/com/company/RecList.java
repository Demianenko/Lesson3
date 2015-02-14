package com.company;

/**
 * Created by sega on 13.02.2015.
 */
public class RecList implements MyList{
    public Node first;



    @Override
    public String toString() {
        if (first == null) {
            return null;
        }
        return first.toString();
    }
    @Override
    public void add(Object o) {
        if (first == null) {
            first = new Node(o,null);
        } else {
            first.add(o);
        }
    }
    @Override
    public int size() {
        if(first==null) {
            return 0;
        } else {
            return first.size();
        }
    }
    @Override
    public boolean isEmpty() {
        return first == null || (first.size() == 0);
    }
    @Override
    public Object get (int i) {
        return first.get(i);
    }
    @Override
    public int indexOf(Object o) {
        if(first==null) {
            return -1;
        } else {
            return first.indexOf(o);
        }

    }
    @Override
    public boolean contains(Object o) {
        if(first==null) {
            return false;
        } else {
            return first.contains(o);
        }
    }
    @Override
    public void put(int i, Object o) {
        first.put(i,o);
    }
    @Override
    public void insert(int i, Object o) {
        if (first == null) {
            first = new Node(o, null);
        } else {
            first.insert(i,o);
        }
    }
    @Override
    public Object remove(int i) {
        if (first==null) {
            return null;
        } else {
            return first.remove(i);
        }

    }
    @Override
    public void clear() {
        first = null;
    }
}
