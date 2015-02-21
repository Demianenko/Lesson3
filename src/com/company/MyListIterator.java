package com.company;

/**
 * Created by user on 21.02.2015.
 */
public interface MyListIterator extends MyIterator {
    boolean hasPrevious();

    Object previous();

    int nextIndex();

    int previousIndex();

    void remove();

    void set(Object e);

    void add(Object e);
}
