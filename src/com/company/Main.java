package com.company;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {


        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("D");
        linkedList.add("a");
        linkedList.add("r");
        linkedList.add("n");
        linkedList.add("e");
        linkedList.add("l");
        linkedList.add("l");

        System.out.println(linkedList);


    }

    /**
     * Time : O(1), Space : O(1)
     */
    public static void deleteNode(LinkedListNode nodeToDelete) {

        LinkedListNode nextNode = nodeToDelete.next;

        if (nextNode != null) {
            nodeToDelete.value = nextNode.value;
            nodeToDelete.next = nextNode.next;

        } else {

            throw new IllegalArgumentException("Can't Delete Last Node");
        }
    }

    /**
     * Time : O(n) , Space: O(1)
     */
    public static boolean containsCycle(LinkedListNode firstNode) {

        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            if (slowRunner == fastRunner) {
                return true;
            }
        }

        return false;
    }

    /**
     * Time : O(n), Space : O(1)
     */
    public static LinkedListNode reverse(LinkedListNode headOfList) {
        LinkedListNode currentNode = headOfList;
        LinkedListNode previousNode = null;
        LinkedListNode nextNode = null;

        while (currentNode != null) {

            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;

        }

        return previousNode;
    }

    /** Time : O(n) , Space : O(1)*/
    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {

        if (k < 1) {
            throw new IllegalArgumentException(" first to last node");
        }

        int listLength = 1;
        LinkedListNode currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            listLength += 1;
        }

        if (k > listLength) {
            throw new IllegalArgumentException(" Larger than the LinkedList");
        }

        int howFar = listLength - k;
        currentNode = head;

        for (int i = 0; i < howFar; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;

    }


    public class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

}


