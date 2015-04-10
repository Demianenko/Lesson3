package com.company;


import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class MyArrayList implements MyList {

    private class MyArrayListIterator implements MyListIterator {
         int cursor = 0;
         int lastReturned = 0;
         private int iteratorsIndexOfChanges = listsIndexOfChanges;

         @Override
         public boolean hasNext() {
             observeChanges();
             return cursor < internalSize;
         }

         @Override
         public Object next() {
             if(!hasNext()) {
                 throw new NoSuchElementException();
             } else {
                 lastReturned = 1;
                 cursor++;
                 return get(cursor-1);
             }
         }
         public boolean hasPrevious() {
             observeChanges();
             return cursor > 0;
         }

         @Override
         public Object previous() {
             observeChanges();
             if(!hasPrevious()) {
                 throw new NoSuchElementException();
             } else {
                 lastReturned = -1;
                 cursor--;
                 return get(cursor);
             }
         }

         @Override
         public void remove() {
             observeChanges();
             if (lastReturned == 1) {
                 MyArrayList.this.remove(cursor - 1);
                 cursor--;
             } else if (lastReturned == -1) {
                 MyArrayList.this.remove(cursor);
             } else {
                 throw new IllegalStateException();
             }
             lastReturned=0;
             iteratorsIndexOfChanges++;
         }

         @Override
         public void set(Object e) {
             if(lastReturned==0) {
                 throw new IllegalStateException();
             }
             observeChanges();
             if(lastReturned==1){
                 MyArrayList.this.put(cursor-1,e);
             } else if (lastReturned==-1) {
                 MyArrayList.this.put(cursor,e);
             }

         }

         @Override
         public void add(Object e) {
             observeChanges();
             if (cursor==internalSize) {
                 MyArrayList.this.add(e);
             } else {
                 MyArrayList.this.insert(cursor,e);
             }
             cursor++;
             iteratorsIndexOfChanges++;
             lastReturned=0;
         }
         @Override
         public int nextIndex() {
             observeChanges();
             return cursor;
         }
         @Override
         public int previousIndex() {
             observeChanges();
             return cursor - 1;
         }

         private void observeChanges () {
             if (iteratorsIndexOfChanges != listsIndexOfChanges) {
                 throw new ConcurrentModificationException("Кто-то, что-то изменил в обход итератора, пока он работал");
             }
         }
     }

    private static final float GOLD_NUMB = 1.62f;
    private static final int FIRST_SIZE = 16;
    private int internalSize = 0;
    private int listsIndexOfChanges = 0;
    private Object[] elements = new Object[FIRST_SIZE];
    public MyArrayListIterator iterator() {
        return new MyArrayListIterator();
    }

    private void doRise() {
        if(internalSize >= elements.length) {
            elements = riceLength(elements);
        }
     }
    private  void doDescend() {
        if(internalSize*2 <= elements.length) {
            elements = descendLength(elements);
        }
     }
    private Object[] riceLength(Object[] src) {
        int newLength = (int)(src.length * GOLD_NUMB);
        Object[] dest = new Object[newLength];
        System.arraycopy(src,0,dest,0,src.length);
        return  dest;
     }
    private Object[]  descendLength (Object[] src) {
        int newLength = (int)(internalSize * GOLD_NUMB);
        Object[] dest = new Object[newLength];
        System.arraycopy(src,0,dest,0,internalSize);
        return  dest;
     }

    private void checkBounds(int poss) {
        if (poss < 0 | poss >= internalSize ) {
        throw new IndexOutOfBoundsException("А туда ли ты попал своим индексом?");
     }
     }
    @Override
    public void add(Object o) {
         elements[internalSize] = o;
         internalSize++;
         listsIndexOfChanges++;
         doRise();
     }

    @Override
    public void insert (int poss, Object o) {
         checkBounds(poss);
         System.arraycopy(elements,poss,elements,poss+1,internalSize-poss);
         put(poss,o);
         internalSize++;
         listsIndexOfChanges++;
         doRise();
     }

    public void put(int poss, Object o) {
        checkBounds(poss);
        elements[poss] = o;
     }

    @Override
    public int indexOf(Object o) {
        for(int i =0; i < internalSize; i++) {
            if (elements[i] == o) {
            return i;
        }
     }
        return -1;
     }

    @Override
    public Object get(int poss) {
        checkBounds(poss);
        return elements[poss];
     }

    @Override
    public int size() {
        return internalSize;
     }

    @Override
    public boolean isEmpty() {
        if (internalSize <= 0) {
            return true;
        }
        else {
            for(int i = 0; i < internalSize; i++) {
                if (elements[i] != null) {
                    return false;
                }
            }
        }
        return true;
     }

    @Override
    public Object remove(int poss) {
         checkBounds(poss);
         Object temp = elements[poss];
         System.arraycopy(elements,poss+1,elements,poss,elements.length-poss-1);
         internalSize--;
         listsIndexOfChanges++;
         doDescend();
         return temp;
     }

    @Override
    public void clear() {
         elements = new Object[elements.length];
     }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < internalSize-1; i++){
            if(elements[i].equals(o)){
                return true;
            }
        }
        return false;
     }

    @Override
    public String toString() {
        String toString ="";
        for (int i = 0; i < this.internalSize; i++) {
            toString += elements[i]+" ";
        }
        return toString;
     }

 }


