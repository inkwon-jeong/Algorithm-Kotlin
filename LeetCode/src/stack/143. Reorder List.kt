package reorderlist

import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun reorderList(head: ListNode?): Unit {
        val stack = Stack<Pair<ListNode, Int>>()
        val queue: Queue<Pair<ListNode, Int>> = LinkedList()

        var node = head
        var index = 0
        while (node != null) {
            stack.push(node to index)
            queue.offer(node to index)
            node = node.next
            index++
        }

        node = null
        var (startNode, startIndex) = queue.poll()
        var (endNode, endIndex) = stack.pop()

        while (startIndex <= endIndex) {
            if(node == null) {
                node = startNode
            } else {
                node.next = startNode
                node = startNode
            }

            if(startIndex != endIndex) {
                node.next = endNode
                node = endNode
            } else break

            val nextStartNode = queue.poll()
            startNode = nextStartNode.first
            startIndex = nextStartNode.second

            val nextEndNode = stack.pop()
            endNode = nextEndNode.first
            endIndex = nextEndNode.second
        }

        node?.next = null
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
