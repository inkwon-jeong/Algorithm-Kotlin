package removeduplicatesfromsortedlist2

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
        val root: ListNode? = nextNode(head)
        var node: ListNode? = root

        while (node != null) {
            val next = nextNode(node.next)
            node.next = next
            node = next
        }

        return root
    }

    private fun nextNode(node: ListNode?): ListNode? {
        if (node == null)
            return null

        var `val` = node.`val`
        var isDuplicated = false

        println(`val`)

        var curr = node
        var next = node.next
        while (next != null) {
            if (`val` != next.`val`) {
                if (!isDuplicated)
                    return curr
                else {
                    `val` = next.`val`
                    isDuplicated = false
                }
            } else {
                isDuplicated = true
            }

            curr = next
            next = next.next
        }

        return if (isDuplicated) null else curr
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}


