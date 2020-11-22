package com.company.linkedlist;

public class FindKthToLastNode2 {

    public static void main(String[] args) {

    }

    /** O(n) run time / O(1) space */
    public static LinkedListNode kthToTheLast2(int k, LinkedListNode head) {

        if (k < 1) {
            throw new IllegalArgumentException("can't be less than 0");
        }

        LinkedListNode leftNode = head;
        LinkedListNode rightNode = head;

        // move rightNode to the kth node

        for (int i = 0; i < k - 1; i++) {
            // but along the way, if a rightNode doesn't have a next,
            // then k is greater than the length of the list and there
            // can't be a kth-to-last node! we'll raise an error
            if (rightNode.next == null) {
                throw new IllegalArgumentException
                        ("K is larger than the length of the List");
            }

            rightNode = rightNode.next;
        }

        // starting with leftNode on the head,
        // move leftNode and rightNode down the list,
        // maintaining a distance of k between them,
        // until rightNode hits the end of the list

        while (rightNode.next != null) {
            leftNode = leftNode.next;
            rightNode = rightNode.next;
        }

        // since leftNode is k nodes behind rightNode,
        // leftNode is now the kth to last node!
        return leftNode;
    }

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }
}
