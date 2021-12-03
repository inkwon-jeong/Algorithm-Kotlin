package splitlinkedlistinparts

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
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val parts = arrayOfNulls<ListNode>(k)
        var len = 0
        var node = head
        while (node != null) {
            len++
            node = node.next
        }
        val n = len / k
        var r = len % k

        node = head
        var prev: ListNode? = null
        var i = 0
        while (node != null && i < k) {
            parts[i] = node
            for (j in 0 until n + if (r > 0) 1 else 0) {
                prev = node
                node = node!!.next
            }
            prev!!.next = null
            i++
            r--
        }
        return parts
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

