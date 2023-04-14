package com.work;

import static org.junit.Assert.*;
import org.junit.Test;

public class TreeTest {

    @Test
    public void testCountLeaves() {
        // Test dla drzewa z treści zadania
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

        assertEquals(5, tree.countLeaves());

        // Test dla drzewa z jednym węzłem
        Node root2 = new Node(1);
        Tree tree2 = new Tree(root2);

        assertEquals(1, tree2.countLeaves());

        // Test dla pustego drzewa
        Tree tree3 = new Tree(null);

        assertEquals(0, tree3.countLeaves());
    }

    @Test
    public void testLongestPath() {
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

        assertEquals(4, tree.longestPath());

         //Test for tree with one node
        Node root2 = new Node(1);
        Tree tree2 = new Tree(root2);

        assertEquals(0, tree2.longestPath());

        // Test for empty tree
        Tree tree3 = new Tree(null);

        assertEquals(0, tree3.longestPath());
    }

    @Test
    public void testEquals() {
        // Test for equal trees
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
        node4.leftChild = node6;
        node6.leftChild = node7;
        node5.leftChild = node8;
        node3.rightChild = node9;
        node9.leftChild = node10;

        Tree tree1 = new Tree(root);
        Tree tree2 = new Tree(root);
        assertTrue(tree1.equals(tree2));

        // Test for different trees
        Node root2 = new Node(5);
        Node node11 = new Node(3);
        Node node12 = new Node(7);
        Node node13 = new Node(3);
        Node node14 = new Node(5);
        Node node15 = new Node(1);
        Node node16 = new Node(0);
        Node node17 = new Node(2);
        Node node18 = new Node(3);
        Node node19 = new Node(5);

        root2.leftChild = node11;
        root2.rightChild = node12;
        node11.leftChild = node13;
        node11.rightChild = node14;
        node13.leftChild = node15;
        node15.leftChild = node16;
        node14.leftChild = node17;
        node12.rightChild = node18;
        node18.leftChild = node19;

        Tree tree3 = new Tree(root2);

        assertFalse(tree1.equals(tree3));
    }
}