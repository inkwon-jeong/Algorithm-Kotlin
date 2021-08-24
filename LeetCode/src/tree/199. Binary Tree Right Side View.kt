package binarytreerightsideview

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

    private val answer = mutableListOf<Int>()

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null)
            return emptyList()

        rightSideView(root, 0)
        return answer
    }

    private fun rightSideView(node: TreeNode, level: Int) {
        if (answer.getOrNull(level) == null)
            answer.add(node.`val`)

        if (node.right != null) rightSideView(node.right!!, level + 1)
        if (node.left != null) rightSideView(node.left!!, level + 1)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

