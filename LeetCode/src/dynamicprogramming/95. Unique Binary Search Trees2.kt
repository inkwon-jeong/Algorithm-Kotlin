package uniquebinarysearchtrees2

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
    fun generateTrees(n: Int): List<TreeNode?> {
        val d = Array<List<TreeNode?>>(n + 1) { mutableListOf() }
        d[0] = listOf(null)
        d[1] = listOf(TreeNode(1))

        for(i in 2..n) {
            val nodes = mutableListOf<TreeNode>()
            for(j in 1..i) {
                for(left in d[j - 1]) {
                    for(right in d[i - j]) {
                        val node = TreeNode(j)
                        node.left = left
                        node.right = convertNode(right, j)
                        nodes.add(node)
                    }
                }
            }
            d[i] = nodes
        }

        return d[n]
    }

    private fun convertNode(node: TreeNode?, extra: Int): TreeNode? {
        if(node == null)
            return null

        if(extra == 0)
            return node

        val newNode = TreeNode(node.`val` + extra)
        newNode.left = convertNode(node.left, extra)
        newNode.right = convertNode(node.right, extra)

        return newNode
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
