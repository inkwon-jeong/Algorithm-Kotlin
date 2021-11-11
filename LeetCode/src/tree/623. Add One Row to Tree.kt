package addonerowtotree

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
    fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
        if (depth == 0 || depth == 1) {
            val newRoot = TreeNode(`val`)
            newRoot.left = if (depth == 1) root else null
            newRoot.right = if (depth == 0) root else null
            return newRoot
        }
        if (root != null && depth >= 2) {
            root.left = addOneRow(root.left, `val`, if (depth > 2) depth - 1 else 1)
            root.right = addOneRow(root.right, `val`, if (depth > 2) depth - 1 else 0)
        }
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
