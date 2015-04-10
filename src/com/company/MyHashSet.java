package com.company;

/**
 * Created by sega on 24.03.2015.
 */
public class MyHashSet implements MyCollection {
    private static final int DEFAULT_CAPACITY = 2;
    private static final float DEFAULT_FILL_RATIO = 0.75f;
    private int capacity;
    private float fillRatio;
    private int internalSize = 0;
    private MyLinkedNode[] elements;

    public MyHashSet(){
        this.capacity = DEFAULT_CAPACITY;
        this.fillRatio = DEFAULT_FILL_RATIO;
        elements = new MyLinkedNode[capacity];
    }
    MyHashSet(int capacity) {
        this.capacity = capacity;
        this.fillRatio = DEFAULT_FILL_RATIO;
        elements = new MyLinkedNode[capacity];
    }
    MyHashSet(int capacity, float fillRatio) {
        this.fillRatio = fillRatio;
        this.capacity = capacity;
        elements = new MyLinkedNode[capacity];
    }
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
    private class MyHashSetIterator implements MyIterator {
        MyLinkedNode newNode;
        MyLinkedNode lastReturned = null;
        int iteratorPlace;
        int lastIteratorPlace=0;
        MyHashSetIterator(){
            if (internalSize==0) {
                this.newNode = new MyLinkedNode();
                this.iteratorPlace = 0;
            } else {
                for(int i =0; i < capacity; i++) {
                    if (elements[i]!=null) {
                        this.iteratorPlace = i;
                        this.newNode = new MyLinkedNode(null,null,elements[i]);
                        return;
                    }
                }
            }
        }
        @Override
        public boolean hasNext() {
            return newNode.getNext()!=null;
        }

        @Override
        public Object next() {
            newNode.setPrevious(newNode.getNext());
            newNode.setValue(newNode.getNext().getValue());
            lastReturned = newNode.getPrevious();
            if (newNode.getNext().getNext()==null) {
                for(int i = iteratorPlace+1; i < capacity; i++) {
                    if(elements[i]!=null) {
                        lastIteratorPlace = iteratorPlace;
                        iteratorPlace = i;
                        newNode.setNext(elements[i]);
                        return newNode.getValue();
                    }
                }
                newNode.setNext(null);
                lastIteratorPlace=iteratorPlace;
                iteratorPlace ++;

            } else {
                newNode.setNext(newNode.getNext().getNext());

            }
            return newNode.getValue();
        }

        @Override
        public void remove() {
            if(lastReturned==null) {
                throw new IllegalStateException();
            }
            if(lastIteratorPlace!=iteratorPlace) {
                if(lastReturned.getPrevious()==null) {
                    elements[lastIteratorPlace] = null;
                } else {
                    lastReturned.getPrevious().setNext(null);
                    lastReturned.setPrevious(null);
                    lastReturned=null;
                    newNode.setPrevious(null);
                }
            } else {
                if(lastReturned.getPrevious()==null) {
                    elements[iteratorPlace] = lastReturned.getNext();
                    newNode.getNext().setPrevious(null);
                    newNode.setPrevious(null);
                    lastReturned=null;
                } else  if(newNode.getNext()!=null) {
                    lastReturned.getPrevious().setNext(newNode.getNext());
                    newNode.getNext().setPrevious(lastReturned.getPrevious());
                    newNode.setPrevious(null);
                    lastReturned=null;
                } else {
                    lastReturned.getPrevious().setNext(newNode.getNext());
                    newNode.setPrevious(null);
                    lastReturned=null;
                }
            }

        }
    }
    private void riceCapacity() {
        int doubleCapacity = (capacity*2);
        if(internalSize >= (int)(doubleCapacity*fillRatio)) {
            MyHashSet tempSet = new MyHashSet(doubleCapacity);
            MyIterator itr = this.iterator();
            while (itr.hasNext()){
                tempSet.add(itr.next());
            }
            this.elements=tempSet.elements;
            this.internalSize = tempSet.internalSize;
            this.capacity=tempSet.capacity;
            System.out.println(this);
            System.out.println(tempSet);
        }

    }
    public boolean add(Object o) {
        riceCapacity();
        if(contains(o)){
            return false;
        }
        int place = o.hashCode()%capacity;
        if(elements[place] == null) {
            elements[place] = new MyLinkedNode(null,o,null);
            internalSize++;
            return true;
        } else {
            MyLinkedNode node = elements[place];
            while (node.getNext()!=null) {
                node = node.getNext();
            }
            MyLinkedNode lastNode = new MyLinkedNode(node,o,null);
            node.setNext(lastNode);
            internalSize++;
            return true;
        }
    }

    @Override
    public int size() {
        return internalSize = 0;
    }

    @Override
    public boolean isEmpty() {
        return internalSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        int place = o.hashCode() % capacity;
        MyLinkedNode node = elements[place];
        while (node != null) {
            if (node.getValue().equals(o)) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int place = o.hashCode()%capacity;
        if(elements[place]==null) {
            return false;
        }
        MyLinkedNode node = elements[place];
        while (node!=null) {
            if(node.getValue().equals(o)){
                if(node.getPrevious()==null&&node.getNext()==null){
                    elements[place] = null;
                } else if(node.getNext()==null) {
                    node.getPrevious().setNext(null);
                } else if(node.getPrevious()==null) {
                    elements[place]=node.getNext();
                    node.getNext().setPrevious(null);
                } else {
                    node.getNext().previous=node.getPrevious();
                    node.getPrevious().next=node.getNext();
                }
                internalSize--;
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    public String toString() {
        String toString ="";
       for (int i = 0; i < this.capacity; i++) {
            if (elements[i] != null) {
                MyLinkedNode node = elements[i];
                String temp =""+ node.getValue();

                while (node.getNext()!=null){
                    node = node.getNext();
                    temp = temp + "->"+node.getValue();
                }

                toString = toString+"[" + temp+"]";
            } else {
                toString += " null ";
            }

        }
        return toString;
    }
    @Override
    public MyIterator iterator() {
        return new MyHashSetIterator();
    }
}
