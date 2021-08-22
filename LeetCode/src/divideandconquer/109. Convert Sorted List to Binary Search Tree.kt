package convertsortedlisttobinarysearchtree

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun sortedListToBST(head: ListNode?): TreeNode? {
        val nodes = mutableListOf<Int>()
        var node = head
        while (node != null) {
            nodes.add(node.`val`)
            node = node.next
        }

        return sortedListToBST(nodes, 0, nodes.lastIndex)
    }

    private fun sortedListToBST(nodes: List<Int>, start: Int, end: Int): TreeNode? {
        if (start > end)
            return null

        val mid = (start + end) / 2
        val rootVal = nodes[mid]
        val rootNode = TreeNode(rootVal)

        rootNode.left = sortedListToBST(nodes, start, mid - 1)
        rootNode.right = sortedListToBST(nodes, mid + 1, end)
        return rootNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

