package com.company.linkedlist;

public class ReverseALinkedList {

    public static void main(String[] args) {

    }
    /** Complexity: O(n) time , O(1) space*/
    public static LinkedListNode reverse(LinkedListNode headOfNode) {
        LinkedListNode currentNode = headOfNode;
        LinkedListNode previousNode = null;
        LinkedListNode nextNode = null;

        // until we have 'fallen off' the end of the list
        while (currentNode != null) {
            // copy a pointer to the next element
            // before we overwrite currentNode.next
            nextNode = currentNode.next;

            // reverse the 'next' pointer
            currentNode.next = previousNode;

            // step forward in the list
            previousNode = currentNode;
            currentNode = nextNode;

        }

        return previousNode;
    }

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }
}
