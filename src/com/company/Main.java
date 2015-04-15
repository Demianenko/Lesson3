package com.company;

public class Main {

    public static void main(String[] args) {
        Person first = new Person(50,"50");
        Person second = new Person(75, "75");
        MyTreeSet<Person> treeSet = new MyTreeSet(new Person.PersonComparator());
        Person p23 = new Person(23,"23");
        treeSet.add(first);
        System.out.println(treeSet);
        treeSet.add(second);
        treeSet.add(new Person(25,"25"));
        treeSet.add(new Person(20,"20"));
        treeSet.add(p23);
        treeSet.add(new Person(20,"20"));
        treeSet.add(new Person(74,"74"));
        treeSet.add(new Person(73,"73"));
        System.out.println(treeSet);
        MyIterator iterator = treeSet.iterator();
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("------rrr50---------");
        treeSet.remove(first);
        MyIterator iterator1 = treeSet.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("------rrr23---------");
        treeSet.remove(p23);
        MyIterator iterator2 = treeSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        //System.out.println(treeSet);
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
