package graph

import java.util.*
import kotlin.collections.ArrayList

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null)
            return null

        val visited = mutableSetOf<Int>()
        val nodes = mutableMapOf<Int, Node>()
        val queue: Queue<Node> = LinkedList()

        visited.add(node.`val`)
        queue.offer(node)
        while (queue.isNotEmpty()) {
            val next = queue.poll()
            if(nodes[next.`val`] == null)
                nodes[next.`val`] = Node(next.`val`)

            next.neighbors.forEach { neighbor ->
                if(neighbor != null) {
                    if (!visited.contains(neighbor.`val`)) {
                        visited.add(neighbor.`val`)
                        queue.offer(neighbor)
                    }

                    val clone = nodes[next.`val`]!!
                    if (nodes[neighbor.`val`] == null) {
                        nodes[neighbor.`val`] = Node(neighbor.`val`)
                    }
                    clone.neighbors.add(nodes[neighbor.`val`])
                }
            }
        }

        return nodes[node.`val`]
    }
}

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}