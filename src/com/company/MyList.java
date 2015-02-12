package com.company;

/**
 * Created by user on 12.02.2015.
 */
public interface MyList {
    void    add(Object o);
    int     size();
    boolean isEmpty();
    Object  get(int i);
    Object  remove(int i);
    void    clear();
    boolean contains(Object o);
    void put(int i, Object o);
    int indexOf(Object o);
    void insert(int i, Object o);
}

