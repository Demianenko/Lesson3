package com.company;




/**
 * Created by sega on 11.04.2015.
 */
public class MyTreeSet<E> {

    private MyTreeNode head;
    private MyTreeNode currentNode;
    private E value;
    private int size = 0;

    public MyComparator<E> comparator;
    MyTreeSet(MyComparator c){
        this.comparator = c;
    }
    MyTreeSet(){
        this.comparator = null;
    }

    private class MyTreeNode {
        private E value;
        private MyTreeNode parent;
        private MyTreeNode left;
        private MyTreeNode right;

        public MyTreeNode(E value, MyTreeNode parent, MyTreeNode left, MyTreeNode right) {
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public MyTreeNode(E value) {
            this(value,null,null,null);
        }
        public MyTreeNode() {
            this(null,null,null,null);
        }
    }
    private class TreeIterator implements MyIterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }

    public Boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public void add(E o) {
        int temp;
        if(size!=0) {
            currentNode = head;
            temp = way(o);
            while (isDeep(temp)) {
                temp = way(o);
            }
            if (temp < 0) {
                currentNode.left = new MyTreeNode(o,currentNode,null,null);
                size++;
                System.out.println("Add in left " + o);
            } else if (temp > 0) {
                currentNode.right = new MyTreeNode(o,currentNode,null,null);
                size++;
                System.out.println("Add in right " + o);
            } else {
                System.out.println("Duplicate" + o);
            }
        } else {
            head = new MyTreeNode(o);
            currentNode = head;
            size++;
            System.out.println("Add in head " + o);
            System.out.println("---------------------------");
        }
    }
    public  boolean contains(E o) {
        currentNode = head;
        int temp = way(o);
        while (isDeep(temp));
        if (temp == 0) {
            return true;
        } else {
            return false;
        }
    }
    public boolean remove (E o) {
        if(size == 0) {
            return false;
        } else if(size == 1) {
            if(way(o)==0) {
                head = null;
                currentNode = head;
                size--;
                return true;
            } else {
                return false;
            }
        } else {
            currentNode = head;
            int temp = way(o);
            while (isDeep(temp)) {
                temp = way(o);
            }
        if (temp == 0) {
            MyTreeNode tempNodeRight = currentNode.right;
            MyTreeNode tempNodeLeft = currentNode.left;
            MyTreeNode tempNodeParent = currentNode.parent;
            if((currentNode.left != null) && (currentNode.right != null)) {
                clearRefers();
                currentNode = tempNodeLeft;
                while (currentNode.right != null) {
                    currentNode = currentNode.right;
                }
                currentNode.right = tempNodeRight;
                tempNodeRight.parent = currentNode;
                if(tempNodeParent == null) {
                    head = currentNode;
                }
                currentNode.parent = tempNodeParent;
            } else if(currentNode.left == null) {
                clearRefers();
                changeHead(tempNodeRight,tempNodeParent);
            } else {
                clearRefers();
                changeHead(tempNodeLeft,tempNodeParent);
            }
            size--;
            return true;
        }
        return false;
        }
    }
    private void clearRefers() {
        currentNode.left = null;
        currentNode.right = null;
        currentNode.parent = null;
    }
    private void changeHead (MyTreeNode tempLeg, MyTreeNode tempHead) {
        currentNode = tempLeg;
        if(tempHead == null) {
            head = currentNode;
        }
        currentNode.parent = tempHead;
    }

    private int way(E o) {
        return comparator.compare(o,currentNode.value);
    }
    private boolean isDeep(int temp) {
        if (temp < 0) {
            if (currentNode.left != null) {
                currentNode = currentNode.left;
                return true;
            }
        }
        if (temp > 0) {
            if (currentNode.right != null) {
                currentNode = currentNode.right;
                return true;
            }
        }
        return false;

    }
}

