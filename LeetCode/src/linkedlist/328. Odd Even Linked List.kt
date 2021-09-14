package oddevenlinkedlist

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
    fun oddEvenList(head: ListNode?): ListNode? {
        var index = 1
        var oddHead: ListNode? = null
        var oddNode: ListNode? = null
        var evenHead: ListNode? = null
        var evenNode: ListNode? = null

        var node = head
        while (node != null) {
            if (index % 2 == 1) {
                if (oddHead == null) {
                    oddHead = node
                    oddNode = node
                } else {
                    oddNode?.next = node
                    oddNode = node
                }
            } else {
                if (evenHead == null) {
                    evenHead = node
                    evenNode = node
                } else {
                    evenNode?.next = node
                    evenNode = node
                }
            }
            node = node.next
            index++
        }

        oddNode?.next = evenHead
        evenNode?.next = null
        return oddHead
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

