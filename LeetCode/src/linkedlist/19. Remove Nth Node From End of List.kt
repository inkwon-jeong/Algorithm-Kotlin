package removenthnodefromendoflist

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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = mutableListOf<ListNode>()
        var node = head
        while (node != null) {
            list.add(node)
            node = node.next
        }

        val index = list.size - n
        return if(index == 0)
            list.getOrNull(1)
        else {
            val prev = list[index - 1]
            val next = list.getOrNull(index + 1)
            prev.next = next
            list[0]
        }
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

