package com.company;

/**
 * Created by sega on 18.03.2015.
 */
public interface MyListIterator {
    boolean hasNext();
    boolean hasPrevious();

    Object previous();
    Object next();
    int nextIndex();

    int previousIndex();

    void remove();
    // если коолекция после создания итератора менялась
    // то этот метод кинет ConcurrentModificationException

    void set(Object e);

    void add(Object e);
}
