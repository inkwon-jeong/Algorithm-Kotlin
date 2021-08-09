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
        val root = ListNode(0)
        root.next = head

        val parentNode = indexOf(root, left - 1)
        val reverseNode = reverse(parentNode?.next, right - left)
        parentNode?.next = reverseNode

        return root.next
    }

    private fun indexOf(root: ListNode?, index: Int): ListNode? {
        var node = root
        repeat(index) { node = node?.next }
        return node
    }

    private fun reverse(head: ListNode?, count: Int): ListNode? {
        var node = head
        var next = head?.next

        repeat(count) {
            val nextNext = next?.next
            next?.next = node
            node = next
            next = nextNext
        }

        head?.next = next
        return node
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

