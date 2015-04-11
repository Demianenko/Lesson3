package com.company;


/**
 * Created by sega on 11.04.2015.
 */
public class MyTreeSet<E> {

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
    private MyTreeNode head;
    private MyTreeNode currentNode;
    private MyTreeNode newNode;
    private int size = 0;

    public Boolean isEmpty() {
        return size == 0;
    }

    public void add(E value) {
        if (size == 0) {
            head = new MyTreeNode(value);
            currentNode = head;
            size++;
        } else {
            newNode = new MyTreeNode(value,currentNode,null,null);


        }

    }
}
