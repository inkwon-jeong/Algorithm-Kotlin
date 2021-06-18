package minimumdistancebetweenbstnodes

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

    private val list = mutableListOf<Int>()

    fun minDiffInBST(root: TreeNode?): Int {
        inorder(root)

        var min = Int.MAX_VALUE
        var prev = list[0]
        for(i in 1..list.lastIndex) {
            val diff = list[i] - prev
            if(diff < min)
                min = diff
            prev = list[i]
        }

        return min
    }

    private fun inorder(node: TreeNode?) {
        if (node == null)
            return

        inorder(node.left)
        list.add(node.`val`)
        inorder(node.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

