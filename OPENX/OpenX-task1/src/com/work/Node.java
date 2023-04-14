package com.work;

public class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}

