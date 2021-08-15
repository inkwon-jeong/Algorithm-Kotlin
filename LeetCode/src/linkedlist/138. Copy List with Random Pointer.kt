package linkedlist

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if(node == null)
            return null

        val nodes = mutableListOf<Node>()
        val nodeMap = mutableMapOf<Node, Node>()
        var curr = node
        while (curr != null) {
            val newNode = Node(curr.`val`)
            newNode.next = curr.next
            newNode.random = curr.random

            nodes.add(newNode)
            nodeMap[curr] = newNode
            curr = curr.next
        }

        var index = 0
        curr = nodes.first()
        while (curr != null) {
            curr.next = nodes.getOrNull(index + 1)
            curr.random = curr.random?.let { nodeMap[it] }
            curr = curr.next
            index++
        }

        return nodes.first()
    }
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}