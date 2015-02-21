package com.company;

/**
 * Created by user on 21.02.2015.
 */
public interface MyCollection {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    MyIterator iterator();

    boolean remove(Object o);

}
