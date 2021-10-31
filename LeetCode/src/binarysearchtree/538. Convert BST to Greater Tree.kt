package convertbsttogreatertree

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

    private var sum = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val newRoot = TreeNode(0)
        convertBST(root, newRoot)
        return newRoot
    }

    private fun convertBST(oldNode: TreeNode, newNode: TreeNode) {
        if (oldNode.right != null) {
            val right = TreeNode(0)
            convertBST(oldNode.right!!, right)
            newNode.right = right
        }

        sum += oldNode.`val`
        newNode.`val` = sum

        if (oldNode.left != null) {
            val left = TreeNode(0)
            convertBST(oldNode.left!!, left)
            newNode.left = left
        }
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

