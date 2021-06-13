package lowestcommonancestorofabinarysearchtree

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    private val depths = mutableMapOf<Int, Int>()
    private val parents = mutableMapOf<Int, TreeNode?>()

    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        init(root)

        var node1 = p
        var node2 = q

        val depth1 = depths[node1?.`val`]!!
        val depth2 = depths[node2?.`val`]!!

        if (depth1 > depth2) {
            repeat(depth1 - depth2) {
                node1 = parents[node1?.`val`]
            }
        } else {
            repeat(depth2 - depth1) {
                node2 = parents[node2?.`val`]
            }
        }

        while (node1 != node2) {
            node1 = parents[node1?.`val`]
            node2 = parents[node2?.`val`]
        }

        return node1
    }

    private fun init(node: TreeNode?, depth: Int = 0, parent: TreeNode? = null) {
        if (node == null)
            return

        depths[node.`val`] = depth
        parents[node.`val`] = parent

        init(node.left, depth + 1, node)
        init(node.right, depth + 1, node)
    }
}

class TreeNode(var `val`: Int = 0) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

