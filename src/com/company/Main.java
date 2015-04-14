package com.company;

public class Main {

    public static void main(String[] args) {
        Person first = new Person(50,"First");
        Person second = new Person(75, "R1");
        MyTreeSet<Person> treeSet = new MyTreeSet(new Person.PersonComparator());


        //treeSet.add(first);
        treeSet.add(second);
        treeSet.add(new Person(25,"L1"));
        treeSet.add(new Person(20,"L2"));
        treeSet.add(new Person(23,"L3"));
        treeSet.add(new Person(20,"L4"));
        System.out.println(treeSet.size());
        System.out.println(treeSet.contains(first));

        MyHashSet set = new MyHashSet();
    }

    public static void testMyHashSet(MyHashSet set) {
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
        System.out.println(set.add(1));
        System.out.println(set);
        System.out.println(set.size());

        System.out.println(set.add(2));
        System.out.println(set);
        System.out.println(set.add(0));
        System.out.println(set);
        System.out.println(set.add(3));
        System.out.println(set);
        System.out.println(set.add(5));
        System.out.println(set);
        System.out.println(set.add(0));
        System.out.println(set.add(1));
        System.out.println(set.add(2));
        System.out.println(set.add(3));
        System.out.println(set.add(5));
        System.out.println(set);
        MyIterator iterator = set.iterator();
        System.out.println("-----------Iterator-----------");
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        iterator.remove();
        System.out.println(set);

    }
    public static void testMyLinkedList(MyList list) {
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.add(0);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.add(1);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.add("h");
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.insert(0,5);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(1);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(0);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(1);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
        list.remove(0);
        System.out.println(list+"  "+list.size());
        System.out.println(list.contains(0));
    }

}
