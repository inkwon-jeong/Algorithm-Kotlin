package mergetwosortedlists

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
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1: ListNode? = l1
        var n2: ListNode? = l2
        var root: ListNode? = null
        var curr: ListNode? = null

        while (n1 != null || n2 != null) {
            val v1 = n1?.`val` ?: Int.MAX_VALUE
            val v2 = n2?.`val` ?: Int.MAX_VALUE

            var next: ListNode?
            if(v1 > v2) {
                next = n2?.let { ListNode(it.`val`) }
                n2 = n2?.next
            } else {
                next = n1?.let { ListNode(it.`val`) }
                n1 = n1?.next
            }

            if(root == null) {
                root = next
                curr = root
            } else {
                curr?.next = next
                curr = curr?.next
            }
        }

        return root
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}