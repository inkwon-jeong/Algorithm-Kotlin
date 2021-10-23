package findlargestvalueineachtreerow

import java.util.*
import kotlin.math.max

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
    fun largestValues(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val answer = mutableListOf<Int>()
        var max = Int.MIN_VALUE
        var currLevel = 0
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.add(root to 0)
        while (queue.isNotEmpty()) {
            val (node, level) = queue.poll()
            max = if (level > currLevel) {
                currLevel = level
                answer.add(max)
                node.`val`
            } else max(max, node.`val`)

            if (node.left != null) queue.add(node.left!! to level + 1)
            if (node.right != null) queue.add(node.right!! to level + 1)
        }
        answer.add(max)
        return answer
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

