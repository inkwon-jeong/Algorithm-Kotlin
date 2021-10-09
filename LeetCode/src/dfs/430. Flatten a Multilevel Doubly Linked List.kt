package flattenamultileveldoublylinkedlist

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var prev: Node? = null
 *     var next: Node? = null
 *     var child: Node? = null
 * }
 */

class Solution {

    fun flatten(root: Node?): Node? {
        flattenTail(root)
        return root
    }

    private fun flattenTail(node: Node?): Node? {
        if (node == null) return node

        return if (node.child == null) {
            if (node.next == null) node else flattenTail(node.next)
        } else {
            val child = node.child
            node.child = null
            val next = node.next
            val childTail = flattenTail(child)
            node.next = child
            child?.prev = node
            if (next != null) {
                childTail?.next = next
                next.prev = childTail
                return flattenTail(next)
            }
            childTail
        }
    }
}

class Node(var `val`: Int) {
    var prev: Node? = null
    var next: Node? = null
    var child: Node? = null
}