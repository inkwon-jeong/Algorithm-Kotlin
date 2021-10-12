package addtwonumbers2

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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var node1: ListNode? = null
        var node2: ListNode? = null
        var curr1 = l1
        var curr2 = l2

        while (curr1 != null || curr2 != null) {
            if (curr1 != null) {
                val newNode = ListNode(curr1.`val`)
                newNode.next = node1
                node1 = newNode
                curr1 = curr1.next
            }

            if (curr2 != null) {
                val newNode = ListNode(curr2.`val`)
                newNode.next = node2
                node2 = newNode
                curr2 = curr2.next
            }
        }

        var carry = 0
        var root: ListNode? = null
        while (node1 != null || node2 != null) {
            val num1 = node1?.`val` ?: 0
            val num2 = node2?.`val` ?: 0
            var sum = num1 + num2 + carry
            if (sum >= 10) {
                carry = 1
                sum -= 10
            } else {
                carry = 0
            }
            val newNode = ListNode(sum)
            newNode.next = root
            root = newNode
            node1 = node1?.next
            node2 = node2?.next
        }

        return if (carry == 0) root
        else {
            ListNode(1).apply { next = root }
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

