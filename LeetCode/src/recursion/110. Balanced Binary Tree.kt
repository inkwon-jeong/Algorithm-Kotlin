package balancedbinarytree

import kotlin.math.max

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
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null)
            return true

        val leftHeight = height(root.left)
        val rightHeight = height(root.right)
        val difference = leftHeight - rightHeight

        if (difference < -1 || difference > 1)
            return false

        return isBalanced(root.left) &&
                isBalanced(root.right)
    }

    private fun height(node: TreeNode?): Int {
        if (node == null)
            return 0

        return max(height(node.left), height(node.right)) + 1
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

