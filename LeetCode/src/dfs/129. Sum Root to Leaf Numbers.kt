package sumroottoleafnumbers

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

    private var answer = 0
    fun sumNumbers(root: TreeNode?): Int {
        if(root == null)
            return 0

        sumNumbers(root, root.`val`)
        return answer
    }

    private fun sumNumbers(node: TreeNode, sum: Int) {
        val left = node.left
        val right = node.right

        if (left == null && right == null) {
            answer += sum
            return
        }

        if(left != null) {
            val nextSum = (sum * 10) + left.`val`
            sumNumbers(left, nextSum)
        }

        if(right != null) {
            val nextSum = (sum * 10) + right.`val`
            sumNumbers(right, nextSum)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

