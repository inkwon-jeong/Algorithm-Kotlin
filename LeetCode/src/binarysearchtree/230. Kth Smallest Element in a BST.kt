package kthsmallestelementinabst

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

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val list = mutableListOf<Int>()
        inorder(root, list)
        return list[k - 1]
    }

    private fun inorder(node: TreeNode?, list: MutableList<Int>) {
        if(node == null)
            return

        inorder(node.left, list)
        list.add(node.`val`)
        inorder(node.right, list)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

