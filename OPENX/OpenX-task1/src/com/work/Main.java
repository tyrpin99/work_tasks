package com.work;

public class Main {

    public static void main(String[] args) {
        Node root = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(5);
        Node node6 = new Node(1);
        Node node7 = new Node(0);
        Node node8 = new Node(2);
        Node node9 = new Node(8);
        Node node10 = new Node(5);

        root.leftChild = node2;
        root.rightChild = node3;

        node2.leftChild = node4;
        node2.rightChild = node5;

        node3.leftChild = node6;
        node3.rightChild = node7;

        node7.leftChild = node8;
        node7.rightChild = node9;

        node9.rightChild = node10;

        Tree tree = new Tree(root);

        int numberOfLeaves = tree.countLeaves();
        System.out.println("Number of leafs: " + numberOfLeaves);

        int longestPath = tree.longestPath();
        System.out.println("Largest number of edges: " + longestPath);

        Tree otherTree = new Tree(root);
        boolean areEqual = tree.equals(otherTree);
        System.out.println("Are trees equal??  :" + areEqual);

    }

}
