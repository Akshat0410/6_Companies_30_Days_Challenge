package com.anupam.challenge.Amazon.Day9;

//Question :- Tree Serialization and Deserialization

import java.util.ArrayList;
import java.util.Scanner;

class Node{

    Node head;
    int data;
    Node left,right;

    Node(int data){

        this.data=data;
        left=null;
        right=null;

    }

    public Node createTree(int[] arr, Node root, int i) {
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

    public void inOrder(Node root){
        if(root == null) return ;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }


}

public class SerializeAndDeserialize {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar =new int[n];
        for(int i=0;i<n;i++) ar[i]=sc.nextInt();

        ArrayList<Integer> A=new ArrayList<>();

        Node node=new Node(0);
        Node head=node.createTree(ar,node.head,0);
        node.inOrder(head);

        serialize(head,A);

        Node ans=deserialize(A);
        node.inOrder(ans);

    }

    static int index=0;

    private static Node deserialize(ArrayList<Integer> A) {


        if (index >= A.size() || A.get(index) == -1) {
            index++;
            return null;
        }

        Node root = new Node(A.get(index++));
        root.left = deserialize(A);
        root.right = deserialize(A);

        return root;
    }


    private static void serialize(Node root, ArrayList<Integer> A) {
        if(root!=null){
            A.add(root.data);
        }else{
            A.add(-1);
            return;
        }
        serialize(root.left,A);
        serialize(root.right,A);
    }




}
