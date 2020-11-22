package com.company.linkedlist;

public class FindKthToLastNode1 {

    public static void main(String[] args) {

    }


    public static LinkedListNode kthToTheLastNode(int k, LinkedListNode head) {

        if (k < 1) {
            throw new IllegalArgumentException("can't find first to last node");
        }

        // STEP 1: get the length of the list
        // start at 1, not 0
        // else we'd fail to count the head node!

        int listLength = 1;
        LinkedListNode currentNode = head;

        // traverse the whole list,
        // counting all the nodes
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            listLength += 1;
        }

        // if k is greater than the length of the list, there can't
        // be a kth-to-last node, so we'll return an error!

        if (k > listLength) {
            throw new IllegalArgumentException("K is larger than the list " + k);
        }

        // STEP 2: walk to the target node
        // calculate how far to go, from the head,
        // to get to the kth to last node

        int howFar = listLength - k;

        currentNode = head;

        for (int i = 0; i < howFar; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }
}
