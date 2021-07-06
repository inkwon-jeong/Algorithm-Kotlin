package flattenbinarytreetolinkedlist

import java.util.*

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
    fun flatten(root: TreeNode?): Unit {
        val queue: Queue<TreeNode> = LinkedList()
        preorder(queue, root)

        var node: TreeNode? = null

        if (queue.isNotEmpty())
            node = queue.poll()

        while (queue.isNotEmpty()) {
            node?.left = null
            node?.right = queue.poll()
            node = node?.right
        }
    }

    private fun preorder(queue: Queue<TreeNode>, node: TreeNode?) {
        if (node == null)
            return

        queue.offer(node)
        preorder(queue, node.left)
        preorder(queue, node.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

