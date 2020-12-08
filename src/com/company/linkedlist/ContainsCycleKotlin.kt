package com.company.linkedlist

fun main() {


}

fun containsCycle(firstNode: ContainsCycle.LinkedListNode): Boolean {
    // start both runners at the beginning
    var slowRunner: ContainsCycle.LinkedListNode = firstNode
    var fastRunner: ContainsCycle.LinkedListNode = firstNode

    // until we hit the end of the list
    while (fastRunner != null && fastRunner.next != null) {

        slowRunner = slowRunner.next
        fastRunner = fastRunner.next.next

        // case: fastRunner is about to "lap" slowRunner
        if (fastRunner == slowRunner) {
            return true
        }
    }
    return false
}


data class Node<T>(var value: T, var next: Node<T>? = null) {

}

class LinkedList<T> {
    private var head: Node<T>? = null
    private var value: Node<T>? = null
    private var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        if (isEmpty()) {
            return "Empty List"
        } else {
            return head.toString()
        }
    }

}