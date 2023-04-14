package com.work;

public class Tree {
    Node root;

    public Tree(Node root) {
        this.root = root;
    }

    public int countLeaves() {
        return countLeavesRecursive(root);
    }

    private int countLeavesRecursive(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.isLeaf()) {
            return 1;
        }

        return countLeavesRecursive(node.leftChild) + countLeavesRecursive(node.rightChild);
    }

    public int longestPath() {
        return longestPathRecursive(root);
    }

    private int longestPathRecursive(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.isLeaf()) {
            return 0;
        }

        int leftPath = longestPathRecursive(node.leftChild);
        int rightPath = longestPathRecursive(node.rightChild);

        return Math.max(leftPath, rightPath)+1;
    }

    public boolean equals(Tree other) {
        return equalsRecursive(root, other.root);
    }

    private boolean equalsRecursive(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.value != node2.value) {
            return false;
        }

        return equalsRecursive(node1.leftChild, node2.leftChild) && equalsRecursive(node1.rightChild, node2.rightChild);
    }
}

