package com.company;

/**
 * Created by sega on 24.03.2015.
 */
public interface MyCollection {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    MyIterator iterator();

    boolean remove(Object o);
}
