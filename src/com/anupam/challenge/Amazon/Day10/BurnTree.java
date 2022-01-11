package com.anupam.challenge.Amazon.Day10;

import java.util.Scanner;

public class BurnTree {

    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();
        Node tree = new Node();
        tree.createTree(ar, tree.head, 0);
        int target = sc.nextInt();
        int ans = minTime(tree.head, target);
        System.out.println(ans);
    }

    private static int minTime(Node root, int target) {

        diameter(root, target);
        return ans;
    }

    private static int diameter(Node root, int target) {
        if (root == null) return 0;
        int x = diameter(root.left, target);
        int y = diameter(root.right, target);
        if (root.data == target) {
            ans = Math.max(x, y);
            return -1;
        }
        if (x < 0) {
            x = Math.abs(x);
            ans = Math.max(ans, x + y);
            return -1 - x;
        }
        if (y < 0) {
            y = Math.abs(y);
            ans = Math.max(ans, x + y);
            return -1 - y;
        }
        if (x < y) return (y + 1);
        else return x + 1;
    }

}


class Node {

    Node head;
    int data;
    Node left, right;

    Node(int data) {

        this.data = data;
        left = null;
        right = null;

    }

    Node() {
        data = 0;
        this.left = null;
        this.right = null;
    }

    Node createTree(int[] arr, Node root, int i) {
        if (i < arr.length) {
            root = new Node(arr[i]);

            // insert left child
            root.left = createTree(arr, root.left,
                    2 * i + 1);

            // insert right child
            root.right = createTree(arr, root.right,
                    2 * i + 2);
        }
        return root;


    }
}