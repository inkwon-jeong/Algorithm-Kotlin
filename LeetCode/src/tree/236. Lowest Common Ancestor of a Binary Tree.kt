package lowestcommonancestorofabinarytree

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private val levelMap = hashMapOf<TreeNode, Int>()
    private val parentMap = hashMapOf<TreeNode, TreeNode?>()

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        lowestCommonAncestor(root!!, null, 0)
        var node1 = p
        var node2 = q

        while (node1 != node2) {
            val level1 = levelMap[node1]!!
            val level2 = levelMap[node2]!!

            when {
                level1 == level2 -> {
                    node1 = parentMap[node1]!!
                    node2 = parentMap[node2]!!
                }
                level1 > level2 -> node1 = parentMap[node1]!!
                level1 < level2 -> node2 = parentMap[node2]!!
            }
        }

        return node1
    }

    private fun lowestCommonAncestor(node: TreeNode, parent: TreeNode?, level: Int) {
        levelMap[node] = level
        parentMap[node] = parent

        if (node.left != null) lowestCommonAncestor(node.left!!, node, level + 1)
        if (node.right != null) lowestCommonAncestor(node.right!!, node, level + 1)
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

