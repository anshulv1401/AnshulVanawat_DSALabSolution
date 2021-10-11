package com.greatlearning.main;

import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LongestPathBT {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        root.left.left.left = new Node(80);
        root.left.left.right = new Node(90);
        root.left.right.left = new Node(100);
        root.left.right.right = new Node(110);
        root.left.left.left.left = new Node(120);

        ArrayList<Node> longestPath = findLongestPath(root);
        System.out.println(longestPath.size());

        for (int i = longestPath.size() - 1; i >= 0; i--) {
            System.out.print("-->" + longestPath.get(i).data);
        }
    }

    private static ArrayList<Node> findLongestPath(Node root) {
        //if the tree is empty (root is null)
        //  return emptyList
        if (root == null) {
            return new ArrayList<Node>();
        }
        if (root.left == null && root.right == null) {
            ArrayList<Node> a = new ArrayList<>();
            a.add(root);
            return a;
        }

        //L = the longest path in the left subtree(root.left) recursive
        //R = the longest path in the Right subtree(root.right) recursive

        ArrayList<Node> L = findLongestPath(root.left);
        ArrayList<Node> R = findLongestPath(root.right);

        //Compare the size of L, R
        //  pick the longer list, and add() to that list
        //  return that list
        if (L.size() > R.size()) {
            L.add(root);
            return L;
        } else {
            R.add(root);
            return R;
        }
    }
}