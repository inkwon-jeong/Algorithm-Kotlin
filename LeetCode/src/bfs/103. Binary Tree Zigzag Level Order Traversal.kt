package binarytreezigzaglevelordertraversal

import java.util.*

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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null)
            return listOf()

        val result = mutableListOf<MutableList<Int>>()
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()

        queue.offer(root to 0)
        while (queue.isNotEmpty()) {
            val (node, level) = queue.poll()
            if(result.getOrNull(level) == null) {
                result.add(mutableListOf())
            }

            if(level % 2 == 0)
                result[level].add(node.`val`)
            else
                result[level].add(0, node.`val`)

            node.left?.let { leftNode ->
                queue.offer(leftNode to level + 1)
            }

            node.right?.let { rightNode ->
                queue.offer(rightNode to level + 1)
            }
        }

        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

