package serializeanddeserializebst

import java.util.*


/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val sb = StringBuilder()
        serialize(root, sb)
        return sb.toString()
    }

    private fun serialize(root: TreeNode?, sb: StringBuilder) {
        if (root == null) return
        sb.append(root.`val`).append(",")
        serialize(root.left, sb)
        serialize(root.right, sb)
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        if (data.isEmpty()) return null
        val queue: Queue<String> = LinkedList(data.split(","))
        return deserialize(queue, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    private fun deserialize(queue: Queue<String>, lower: Int, upper: Int): TreeNode? {
        if (queue.isEmpty()) return null
        val s: String = queue.peek()
        val `val` = s.toIntOrNull() ?: return null
        if (`val` < lower || `val` > upper) return null
        queue.poll()
        val root = TreeNode(`val`)
        root.left = deserialize(queue, lower, `val`)
        root.right = deserialize(queue, `val`, upper)
        return root
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Your Codec object will be instantiated and called as such:
 * val ser = Codec()
 * val deser = Codec()
 * val tree: String = ser.serialize(root)
 * val ans = deser.deserialize(tree)
 * return ans
 */

