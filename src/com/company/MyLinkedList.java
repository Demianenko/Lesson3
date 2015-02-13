package com.company;

/**
 * Created by user on 12.02.2015.
 */
public class MyLinkedList implements MyList {
    private MyLinkedNode first;

    @Override
    public void add(Object o) {
        if (first == null) {
            first = new MyLinkedNode(o,null);
        } else {
            for(MyLinkedNode node = first; node != null; node=node.getNext()) {
                if(node.getNext() == null) {
                    node.setNext(new MyLinkedNode(o, null));
                    return;
                }
            }
        }
    }

    public void addInStart(Object o) {
        MyLinkedNode head = new MyLinkedNode(o,null);
        head.setNext(first);
        first = head;
    }

    @Override
    public void insert(int i, Object o) {
        if (i > this.size() | i < 0) {
            throw new IndexOutOfBoundsException("Мимо");
        }
        if (i == 0) {
            addInStart(o);
        } else {
            int temp = 0;
            MyLinkedNode head = new MyLinkedNode(o,null);
            for(MyLinkedNode node = first; node != null; node=node.getNext()) {
                if(temp+1 == i) {
                    head.setNext(node.getNext());
                    node.setNext(head);
                    return;
                }
                temp++;
            }
        }

    }

    @Override
    public String toString() {
        String temp = "";
        for (MyLinkedNode node = first; node != null; node = node.getNext()) {
            temp += node.getValue();
        }
        return temp;
    }

    @Override
    public int size() {
        int size = 0;
        for(MyLinkedNode node = first; node != null; node=node.getNext()) {
            size++;
            if(node.getNext() == null) {
            return size;
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public Object get(int i) {
        if (i >= this.size() | i < 0) {
            throw new IndexOutOfBoundsException("Мимо");
        }
        int temp = 0;
        for (MyLinkedNode node = first; node != null; node = node.getNext()) {
            if (temp == i) {
                return node.getValue();
            }
            temp++;
        }
        return null;
    }

    public  Object removeFromStart(){
        Object removed = first.getValue();
        first = first.getNext();
        return removed;
    }

    @Override
    public Object remove(int i) {
        if (i >= this.size()| i < 0) {
            throw new IndexOutOfBoundsException("Мимо");
        }
        if(i==0) {
           return removeFromStart();
        } else {
            Object removed = new IndexOutOfBoundsException("Что то пошло не так");
            int temp = 0;
            for (MyLinkedNode node = first; node != null; node = node.getNext()) {
                if (temp+1 == i) {
                    removed = node.getNext().getValue();
                    node.setNext(node.getNext().getNext());
                }
                temp++;
            }
            return removed;
        }
    }

    @Override
    public void clear() {
        first = null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void put(int i, Object o) {
        if (i >= this.size()| i < 0) {
            throw new IndexOutOfBoundsException("Мимо");
        }
        int temp = 0;
        for (MyLinkedNode node = first; node != null; node = node.getNext()) {
            if (temp == i) {
                node.setValue(o);
            }
            temp++;
        }
    }

    @Override
    public int indexOf(Object o) {
        int temp = 0;
        for (MyLinkedNode node = first; node != null; node = node.getNext()) {
            if (node.getValue().equals(o)) {
                return temp;
            }
            temp++;
        }
        return -1;
    }


}