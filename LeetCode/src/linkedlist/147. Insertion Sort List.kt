package insertionsortlist

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
    fun insertionSortList(head: ListNode?): ListNode? {
        val root = ListNode(0)
        root.next = head

        var prevNode = head
        var currNode = head?.next
        var nextNode = currNode?.next

        while (currNode != null) {
            var prev = root
            var curr = root.next

            while (curr != null && curr != currNode) {
                if (curr.`val` > currNode.`val`) {
                    prev.next = currNode
                    currNode.next = curr
                    prevNode?.next = nextNode
                    break
                } else {
                    prev = curr
                    curr = curr.next
                }
            }

            prevNode = if (curr == currNode) currNode else prevNode
            currNode = nextNode
            nextNode = nextNode?.next
        }

        return root.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

