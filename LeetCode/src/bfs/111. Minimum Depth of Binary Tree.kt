package minimumdepthofbinarytree

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
    fun minDepth(root: TreeNode?): Int {
        if(root == null)
            return 0

        var answer = 0
        val queue: Queue<Pair<TreeNode, Int>> = LinkedList()
        queue.add(root to 1)
        loop@ while (!queue.isEmpty()) {
            val (node, depth) = queue.poll()
            if(node.left == null && node.right == null) {
                answer = depth
                break@loop
            }

            if(node.left != null)
                queue.add(node.left!! to (depth + 1))

            if(node.right != null)
                queue.add(node.right!! to (depth + 1))
        }

        return answer
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

