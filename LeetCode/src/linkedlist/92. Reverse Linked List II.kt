package reverselinkedlist2

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
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var node: ListNode? = nextNode(head, left)

    }

    private fun indexOf(node: ListNode?, count: Int): ListNode? {
        var curr = node
        repeat(count) {
            if (curr == null) return null
            curr = curr?.next
        }
        return curr
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

