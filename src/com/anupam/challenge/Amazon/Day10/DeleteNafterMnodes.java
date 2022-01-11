package com.anupam.challenge.Amazon.Day10;
public class DeleteNafterMnodes {

    private static void linkDelete(Node head, int m, int n) {
            Node temp = head;
            int mul = 1, count =1;
            int x =n;

            while(temp != null && temp.next != null){
                if(count==m*mul){
                    Node prev=temp;
                    while(x>0&&temp.next!=null){
                        temp=temp.next;
                        x--;
                    }
                    prev.next=temp.next;
                    mul++;
                    x=n;
                }
                count++;
                temp=temp.next;
            }
        }
}
