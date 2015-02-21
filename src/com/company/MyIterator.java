package com.company;

/**
 * Created by user on 21.02.2015.
 */
public interface MyIterator {
    boolean hasNext();

    void remove();
    // если коолекция после создания итератора менялась
    // то этот метод кинет ConcurrentModificationException
    Object next();
}
