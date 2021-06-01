package removeduplicatesfromsortedlist

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
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var currNode = head
        var prevNode = currNode

        var prev = Int.MIN_VALUE
        while (currNode != null) {
            if(prev != currNode.`val`) {
                prev = currNode.`val`
                prevNode = currNode
                currNode = currNode.next
            } else {
                currNode = currNode.next
                prevNode?.next = currNode
            }
        }

        return head
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

