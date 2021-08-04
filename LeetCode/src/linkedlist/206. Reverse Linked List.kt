package reverselinkedlist

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
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null)
            return null

        var prev = head
        var next = prev.next
        prev.next = null

        while (next != null) {
            val nextNext = next.next
            next.next = prev
            prev = next
            next = nextNext
        }

        return prev
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

