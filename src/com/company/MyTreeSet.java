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

    public Boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }

    public void add(E value) {

        if (size == 0) {
            head = new MyTreeNode(value);
            currentNode = head;
            size++;
            System.out.println("Add in head " + currentNode.value);
            System.out.println("---------------------------");
        } else {
            this.value = value;
            goDeep();
            System.out.println("---------------------------");

        }

    }
    private void goDeep() {
        System.out.println("Go deeper");
        int temp = comparator.compare(value,currentNode.value);
        if (temp > 0){
            System.out.println("Right leg");
            if(currentNode.right!=null) {
                currentNode = currentNode.right;
                goDeep();
            } else {
                currentNode.right = new MyTreeNode(value,currentNode,null,null);
                System.out.println("add in right " + currentNode.value);
                size++;
            }
        } else if (temp < 0) {
            System.out.println("Left leg");
            if(currentNode.left!=null) {
                currentNode = currentNode.left;
                goDeep();
            } else {
                currentNode.left = new MyTreeNode(value,currentNode,null,null);
                System.out.println("add in left " + currentNode.value);
                size++;
            }
        } else {
            System.out.println("Duplicate "+currentNode.value);
        }
    }

}
//newNode = new MyTreeNode(value,currentNode,null,null);