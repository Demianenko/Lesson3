package com.company;

/**
 * Created by user on 12.02.2015.
 */
public interface MyList extends MyCollection {
    void    add(Object o);
    Object  get(int i);
    Object  remove(int i);
    void    clear();
    boolean contains(Object o);
    int     size();
    boolean isEmpty();
    void put(int i, Object o);
    int indexOf(Object o);
    void insert(int i, Object o);
    public MyIterator iterator();
}

