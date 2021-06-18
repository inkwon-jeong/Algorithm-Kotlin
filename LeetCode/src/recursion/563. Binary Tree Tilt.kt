package binarytreetilt

import kotlin.math.absoluteValue

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
    fun findTilt(root: TreeNode?): Int {
        if(root == null)
            return 0

        val sum = (sum(root.left) - sum(root.right)).absoluteValue
        return sum + findTilt(root.left) + findTilt(root.right)
    }

    private fun sum(node: TreeNode?): Int {
        if(node == null)
            return 0

        return sum(node.left) + sum(node.right) + node.`val`
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
