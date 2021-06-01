package linkedlistcycle

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
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var slow = head
        var fast = head.next
        while(slow != fast) {
            if (fast?.next == null)
                return false

            slow = slow?.next
            fast = fast.next?.next
        }
        return true
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

