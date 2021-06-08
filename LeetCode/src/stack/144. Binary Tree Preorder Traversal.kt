package binarytreepreordertraversal

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
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        preorderTraversal(root, list)
        return list
    }

    private fun preorderTraversal(node: TreeNode?, list: MutableList<Int>) {
        node?.let {
            list.add(node.`val`)
            preorderTraversal(node.left, list)
            preorderTraversal(node.right, list)
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

