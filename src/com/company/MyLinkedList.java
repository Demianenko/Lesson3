package com.company;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Created by user on 12.02.2015.
 */
public class MyLinkedList implements MyList {

    private class MyLinkedNode {
        private MyLinkedNode next;
        private Object value;
        private MyLinkedNode previous;

        public MyLinkedNode() {
            next = null;
            value = null;
            previous = null;
        }

        public MyLinkedNode(MyLinkedNode previous, Object value, MyLinkedNode next ) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

        public MyLinkedNode getNext() {
            return next;
        }

        public Object getValue() {
            return value;
        }

        public MyLinkedNode getPrevious() {
            return previous;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setNext(MyLinkedNode next) {
            this.next = next;
        }
        public void setPrevious (MyLinkedNode previous) {
            this.previous = previous;
        }
    }
    private class MyLinkedListIterator implements MyListIterator {
        MyLinkedNode newNode = new MyLinkedNode(null,null,first);
        MyLinkedNode lastReturned = null;
        private int index = 0;
        private int iteratorsIndexOfChanges = listsIndexOfChanges;

        private void observeChanges () {
            if (iteratorsIndexOfChanges != listsIndexOfChanges) {
                throw new ConcurrentModificationException("Кто-то, что-то изменил в обход итератора, пока он работал");
            }
        }

        @Override
        public boolean hasNext() {
            observeChanges();
            return newNode.next != null;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            index++;
            newNode.previous = newNode.next;
            newNode.value = newNode.next.value;
            newNode.next = newNode.next.next;
            lastReturned = newNode.previous;
            return newNode.value;
        }
        @Override
        public boolean hasPrevious() {
            observeChanges();
            return newNode.previous != null;
        }
        @Override
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            index--;
            newNode.next = newNode.previous;
            newNode.value = newNode.previous.value;
            newNode.previous = newNode.previous.previous;
            lastReturned = newNode.next;
            return newNode.value;
        }
        @Override
        public int nextIndex() {
            observeChanges();
            if (hasNext()) {
                return index;
            } else {
                return size();
            }

        }

        @Override
        public int previousIndex() {
            observeChanges();
            if (hasPrevious()) {
                return index-1;
            } else {
                return -1;
            }

        }

        @Override
        public void remove() {
            if (lastReturned==null) {
                throw new IllegalStateException();
            }
            observeChanges();
            if (lastReturned == newNode.previous) {
                removeNext();
            } else {
                if (lastReturned == newNode.next) {
                    removePrevious();
                } else {
                    throw new NoSuchElementException();
                }
            }
            lastReturned=null;
            listsIndexOfChanges++;
            iteratorsIndexOfChanges++;

        }
        private void removeNext() {
            if(newNode.previous.previous==null) {
                first = newNode.next;
            } else {
                if(newNode.getNext()!=null) {
                    newNode.previous.previous.setNext(newNode.next);
                    newNode.setPrevious(newNode.previous.previous);
                    newNode.next.setPrevious(newNode.previous);
                } else {
                    newNode.previous.previous.setNext(newNode.next);
                    newNode.setPrevious(newNode.previous.previous);
                }

            }
            index --;
        }
        private void removePrevious() {
            if (newNode.next.next==null) {
                if (newNode.previous == null) {
                    first = null;
                    newNode = new MyLinkedNode();
                } else {
                    newNode.previous.next = null;
                    newNode.next = null;
                }
            } else {
                if (newNode.previous == null) {
                    first = newNode.next.next;
                } else {
                    newNode.previous.next = newNode.next.next;
                }
            }
        }


        public void set(Object e) {
            if(lastReturned==null) {
                throw new IllegalStateException();
            }
            observeChanges();
            lastReturned.setValue(e);
        }

        public void add(Object e) {
            observeChanges();
            lastReturned = null;
            MyLinkedNode node = new MyLinkedNode(newNode.previous,e,newNode.next);
            if (first == null) {
                first = node;
                newNode.previous = node;
            } else {
                if (newNode.previous == null) {
                    first = node;
                    newNode.previous = node;
                    newNode.next.previous = node;
                } else if (newNode.next == null){
                    newNode.previous.next = node;
                    newNode.previous = node;
                } else {
                    newNode.previous.next = node;
                    newNode.next.previous = node;
                    newNode.previous = node;
                }
            }
            index++;
            listsIndexOfChanges++;
            iteratorsIndexOfChanges++;
        }
    }

    public MyListIterator iterator() {
        return new MyLinkedListIterator();
    }
    private MyLinkedNode first;
    private int listsIndexOfChanges = 0;



    @Override
    public void add(Object o) {
        listsIndexOfChanges++;
        if (first == null) {
            first = new MyLinkedNode(null,o,null);
        } else {
            MyLinkedNode node = first;
            while (node.getNext()!=null) {
                node = node.getNext();
            }
            node.setNext(new MyLinkedNode(node, o, null));
        }
    }

    public void addInStart(Object o) {
        listsIndexOfChanges++;
        MyLinkedNode head = new MyLinkedNode(null,o,first);
        first.setPrevious(head);
        first = head;
    }

    @Override
    public void insert(int i, Object o) {
        listsIndexOfChanges++;
        if (i > this.size() | i < 0) {
            throw new IndexOutOfBoundsException("Мимо");
        }
        if (i == 0) {
            addInStart(o);
        } else {
            MyLinkedNode node = first;
            while (node.getNext()!=null) {
                node=node.getNext();
                i--;
                if (i==0) {
                    MyLinkedNode head = new MyLinkedNode(node.getPrevious(),o,node);
                    node.getPrevious().setNext(head);
                    node.setPrevious(head);
                }
            }
        }

    }

    @Override
    public String toString() {
        String temp = "";
        for (MyLinkedNode node = first; node != null; node = node.getNext()) {
            //temp += node.getValue();
            temp+=changeSymbol(node);
        }
        return temp;
    }

    private String changeSymbol(MyLinkedNode node) {
        String temp = "";
        if(node.getPrevious()==null) {
            temp = "*";
        } else {
            temp = "<-";
        }
        temp = temp + node.getValue();
        if (node.getNext()==null) {
            temp = temp + "*";
        } else {
            temp = temp + "->";
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
        listsIndexOfChanges++;
        Object removed = first.getValue();
        first = first.getNext();
        if (first!=null) {
            first.previous = null;
        }
        return removed;
    }

    @Override
    public Object remove(int i) {
        listsIndexOfChanges++;
        if (i >= this.size()| i < 0) {
            throw new IndexOutOfBoundsException("Мимо");
        }
        if(i==0) {
            return removeFromStart();
        } else {
            MyLinkedNode node = first;
            Object removed = null;
            while (node.getNext()!=null){
                node = node.getNext();
                i--;
                if(i==0) {
                    if(node.getNext()!=null) {
                        node.getPrevious().setNext(node.getNext());
                        node.getNext().setPrevious(node.getPrevious());
                        removed = node.getValue();
                    } else {
                        node.getPrevious().setNext(node.getNext());
                        removed = node.getValue();
                    }

                }
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
        if (first != null && indexOf(o) >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void put(int i, Object o) {
        listsIndexOfChanges++;

            if(this.size()==0) {
                throw new IndexOutOfBoundsException("Список отсутствует");
            }
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
        MyLinkedNode node = first;
        if (node == null) {
            return -1;
        }
        int temp = 0;
        do {
            if(node.getValue().equals(o)) {
                return temp;
            }
            else {
                node = node.getNext();
                temp++;
            }
        }
        while (node!=null);
        return -1;
    }

}