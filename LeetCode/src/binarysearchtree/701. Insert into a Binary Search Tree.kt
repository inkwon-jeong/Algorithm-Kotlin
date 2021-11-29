package insertintoabinarysearchtree

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
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) return TreeNode(`val`)
        var cur = root
        while (true) {
            if (cur!!.`val` <= `val`) {
                if (cur.right != null) cur = cur.right else {
                    cur.right = TreeNode(`val`)
                    break
                }
            } else {
                if (cur.left != null) cur = cur.left else {
                    cur.left = TreeNode(`val`)
                    break
                }
            }
        }
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

