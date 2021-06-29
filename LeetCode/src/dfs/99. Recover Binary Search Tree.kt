package recoverbinarysearchtree

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
    fun recoverTree(root: TreeNode?): Unit {
        isValid(root, root, null, null)
    }

    private fun isValid(root: TreeNode?, node: TreeNode?, start: TreeNode?, end: TreeNode?) {
        if (node == null)
            return

        if (start != null && start.`val` >= node.`val`) {
            swap(start, node)
            isValid(root, root, null, null)
            return
        }

        if (end != null && end.`val` <= node.`val`) {
            swap(end, node)
            isValid(root, root, null, null)
            return
        }

        isValid(root, node.left, start, node)
        isValid(root, node.right, node, end)
    }

    private fun swap(node1: TreeNode, node2: TreeNode) {
        val temp = node1.`val`
        node1.`val` = node2.`val`
        node2.`val` = temp
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

