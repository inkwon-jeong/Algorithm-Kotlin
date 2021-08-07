package partitionlist

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
    fun partition(head: ListNode?, x: Int): ListNode? {
        var leftRoot: ListNode? = null
        var leftNode: ListNode? = null
        var rightRoot: ListNode? = null
        var rightNode: ListNode? = null

        var node = head
        while (node != null) {
            if (node.`val` < x) {
                if (leftRoot == null) {
                    leftRoot = node
                    leftNode = node
                } else {
                    leftNode?.next = node
                    leftNode = node
                }
            } else {
                if (rightRoot == null) {
                    rightRoot = node
                    rightNode = node
                } else {
                    rightNode?.next = node
                    rightNode = node
                }
            }
            node = node.next
        }

        leftNode?.next = rightRoot
        rightNode?.next = null

        return leftRoot ?: rightRoot
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

