package com.company;


import java.util.LinkedList;
import java.util.List;

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
        private List<MyTreeNode> listOfTreeNode;

        public TreeIterator() {
            this.listOfTreeNode = new LinkedList<MyTreeNode>();
            listOfTreeNode.add(head);
        }
        @Override
        public boolean hasNext() {
            return (!listOfTreeNode.isEmpty());
        }

        @Override
        public E next() {
            E temp = listOfTreeNode.get(0).value;
            MyTreeNode tempLeft = listOfTreeNode.get(0).left;
            MyTreeNode tempRight = listOfTreeNode.get(0).right;
            addToList(tempLeft);
            addToList(tempRight);
            listOfTreeNode.remove(0);
            return temp;
        }
        private void addToList(MyTreeNode leg){
            if (leg != null) {
                listOfTreeNode.add(leg);
            }
        }
        @Override
        public void remove() {

        }
    }
    private class TreeIteratorDeep implements MyIterator {
        MyTreeNode node;
        int lastLeg = 0;
        E lastValue;
        public TreeIteratorDeep(){
            this.node = new MyTreeNode(null,null,null,head);
        }
        @Override
        public boolean hasNext() {
            do {
                if ((node.left != null) && (node.left != lastValue)) {
                    lastValue = node.left.value;
                    lastLeg = -1;
                    return true;
                } else if ((node.right != null) && (node.right != lastValue)) {
                    lastValue = node.right.value;
                    lastLeg = 1;
                    return true;
                } else {
                    if (node.parent != null) {
                        node = node.parent;
                    }
                }
            } while (node.parent != null);
            return false;
        }

        @Override
        public E next() {
            return lastValue;
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
    public MyIterator iterator() {
        return new TreeIterator();
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
            } else if (temp > 0) {
                currentNode.right = new MyTreeNode(o,currentNode,null,null);
                size++;
            }
        } else {
            head = new MyTreeNode(o);
            currentNode = head;
            size++;
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

    public String toString() {
        String temp = "";
        TreeIterator iterator = new TreeIterator();
        while (iterator.hasNext()) {
            temp += iterator.listOfTreeNode.get(0).value + " ";
            iterator.next();
        }
        return temp;
    }

    public StringBuilder toStringTree() {
        StringBuilder temp = new StringBuilder();
        MyTreeNode node = head;
        MyTreeNode nodeLeft;
        MyTreeNode nodeRight;
        temp.append(filter(node));
        while (node != null) {
            nodeLeft = node.left;
            nodeRight = node.right;
            temp.append(filter(nodeLeft)).append(filter(nodeRight));

            if (nodeLeft != null) {
                node = nodeLeft;
            } else if (nodeRight != null) {
                node = nodeRight;
            } else {
                node = null;
            }

        }
        return temp;
    }
    private String filter(MyTreeNode node) {
        String filter;
        if (node == null) {
            filter = "null!";
        } else {
            filter = node.value.toString();
        }
        return filter;
    }
}

