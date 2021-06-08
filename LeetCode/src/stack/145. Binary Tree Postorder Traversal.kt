package binarytreepostordertraversal

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
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        postorderTraversal(root, list)
        return list
    }

    private fun postorderTraversal(node: TreeNode?, list: MutableList<Int>) {
        node?.let {
            postorderTraversal(node.left, list)
            postorderTraversal(node.right, list)
            list.add(node.`val`)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
