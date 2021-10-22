package findbottomlefttreevalue

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

    private var maxLevel = 0
    private var answer = 0

    fun findBottomLeftValue(root: TreeNode?): Int {
        if (root == null) return 0
        findBottomLeftValue(root, 1)

        return answer
    }

    private fun findBottomLeftValue(node: TreeNode, level: Int) {
        if (level > maxLevel) {
            answer = node.`val`
            maxLevel = level
        }

        if (node.left != null) findBottomLeftValue(node.left!!, level + 1)
        if (node.right != null) findBottomLeftValue(node.right!!, level + 1)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

