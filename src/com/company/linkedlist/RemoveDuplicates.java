package com.company.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {



    }

    /**
     * Space-time complexity == O(n)
     */
    public static LinkedListNode removeDuplicates(LinkedListNode head) {
        //current node is assigned to head
        LinkedListNode currentNode = head;

        // create hashset because sets do not contain duplicates
        HashSet<Integer> hashSet = new HashSet<>();
        // add current value to hashset. this will be done with the very first node.
        hashSet.add(currentNode.value);

        //iterate through the LinkedList , if the hashSet already contains the next nodes value, we skip it.
        // this dereferences the node and will eventually delete that node
        while (currentNode.next != null) {
            if (hashSet.contains(currentNode.next.value)) {
                currentNode.next = currentNode.next.next;
            } else {
                // if the value is not in the hashset we add it to the hashset and move forward
                hashSet.add(currentNode.next.value);
                currentNode = currentNode.next;
            }
        }
        //return the head
        return head;
    }


    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode() {
            this.value = value;
        }
    }
}
