package swapnodesinpairs

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
    fun swapPairs(head: ListNode?): ListNode? {
        if(head?.next == null)
            return head

        val root = head.next
        var cur: ListNode? = head
        var next: ListNode? = head.next
        var prev: ListNode? = null
        while (cur != null && next != null) {
            val nextNext = next.next

            next.next = cur
            prev?.next = next
            cur.next = nextNext

            prev = cur
            cur = nextNext
            next = cur?.next
        }

        return root
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

