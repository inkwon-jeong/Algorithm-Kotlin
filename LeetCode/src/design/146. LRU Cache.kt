package lrucache

class LRUCache(private val capacity: Int) {

    private val nodes = mutableMapOf<Int, Node>()
    private var startNode: Node? = null
    private var lastNode: Node? = null

    fun get(key: Int): Int {
        if (nodes[key] == null)
            return -1

        val node = nodes[key]!!
        if (node.prev != null) {
            val prev = node.prev!!
            val next = node.next

            node.prev = null
            node.next = startNode

            startNode?.prev = node
            startNode = node

            prev.next = next
            if(next == null)
                lastNode = prev
            else
                next.prev = prev
        }

        return node.value
    }

    fun put(key: Int, value: Int) {
        if(nodes[key] == null) {
            val node = Node(key, value)

            when {
                nodes.isEmpty() -> {
                    startNode = node
                    lastNode = node
                }
                nodes.size < capacity -> {
                    node.next = startNode
                    startNode?.prev = node
                    startNode = node
                }
                else -> {
                    node.next = startNode
                    startNode?.prev = node
                    startNode = node

                    val lastKey = lastNode!!.key
                    nodes.remove(lastKey)
                    lastNode = lastNode?.prev
                    lastNode?.next = null
                }
            }

            nodes[key] = node
        } else {
            val node = nodes[key]!!
            if (node.prev != null) {
                val prev = node.prev!!
                val next = node.next

                node.prev = null
                node.next = startNode

                startNode?.prev = node
                startNode = node

                prev.next = next
                if(next == null)
                    lastNode = prev
                else
                    next.prev = prev
            }

            node.value = value
        }
    }

    data class Node(
        var key: Int,
        var value: Int,
        var prev: Node? = null,
        var next: Node? = null
    )
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

