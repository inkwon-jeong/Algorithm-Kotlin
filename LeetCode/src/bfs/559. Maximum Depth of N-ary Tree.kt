package maximumdepthofnarytree

/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var children: List<Node?> = listOf()
 * }
 */

class Solution {
    fun maxDepth(root: Node?): Int {
        if(root == null)
            return 0

        var max = 0
        root.children.forEach { node ->
            if(node != null) {
                val depth = maxDepth(node)
                if(max < depth)
                    max = depth
            }
        }

        return max + 1
    }
}

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

