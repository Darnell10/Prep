package com.company.linkedlist;

public class ContainsCycle {

    public static void main(String[] args) {


    }

    /** time complexity O(n) Space O(1)*/
    public static boolean containsCycle(LinkedListNode firstNode) {

        // start both runners at the beginning
        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        // until we hit the end of the list
        while (fastRunner != null && fastRunner.next != null) {

            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            // case: fastRunner is about to "lap" slowRunner
            if (fastRunner == slowRunner) {
                return true;

            }
        }

        return false;
    }
    /** Time : O(n) , Space : O(1)
     * this varien returns the node that is the origin of the loop*/
    public static LinkedListNode findLoop(LinkedListNode head) {

        LinkedListNode	slowRunner = head.next;
        LinkedListNode	fastRunner = head.next.next;

        while(slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;
        }

        slowRunner = head;

        while(slowRunner != fastRunner){
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next;
        }

        return slowRunner;
    }


    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }
}
