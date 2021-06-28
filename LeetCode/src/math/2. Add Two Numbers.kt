package addtwonumbers

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
        var n1 = l1
        var n2 = l2

        var carry = 0
        var root: ListNode? = null
        var node: ListNode? = null

        while (n1 != null || n2 != null) {
            var sum = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + carry
            if (sum >= 10) {
                carry = 1
                sum -= 10
            } else {
                carry = 0
            }

            val newNode = ListNode(sum)
            if(root == null) {
                root = newNode
                node = root
            } else {
                node?.next = newNode
                node = newNode
            }

            n1 = n1?.next
            n2 = n2?.next
        }

        if(carry == 1)
            node?.next = ListNode(1)

        return root
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}



