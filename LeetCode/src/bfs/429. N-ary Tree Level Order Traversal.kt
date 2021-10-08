package narytreelevelordertraversal

import java.util.*

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {

    fun levelOrder(root: Node?): List<List<Int>> {
        if (root == null) return emptyList()
        val answer = mutableListOf<MutableList<Int>>()
        val queue: Queue<Pair<Node, Int>> = LinkedList()
        queue.add(root to 0)
        while (!queue.isEmpty()) {
            val (node, level) = queue.poll()
            if (answer.getOrNull(level) == null) {
                answer.add(mutableListOf(node.`val`))
            } else {
                answer[level].add(node.`val`)
            }
            node.children.forEach { child ->
                child?.let { queue.add(child to (level + 1)) }
            }
        }
        return answer
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

