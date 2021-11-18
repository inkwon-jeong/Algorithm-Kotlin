package findduplicatesubtrees

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

    var curId = 1

    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        val serialToId = mutableMapOf<String, Int>()
        val idToCount = mutableMapOf<Int, Int>()
        val res = mutableListOf<TreeNode>()
        postorder(root, serialToId, idToCount, res)
        return res
    }

    private fun postorder(
        root: TreeNode?,
        serialToId: MutableMap<String, Int>,
        idToCount: MutableMap<Int, Int>,
        res: MutableList<TreeNode>
    ): Int {
        if (root == null) return 0
        val leftId = postorder(root.left, serialToId, idToCount, res)
        val rightId = postorder(root.right, serialToId, idToCount, res)
        val curSerial = leftId.toString() + "," + root.`val` + "," + rightId
        val serialId = serialToId.getOrDefault(curSerial, curId)
        if (serialId == curId) curId++
        serialToId[curSerial] = serialId
        idToCount[serialId] = idToCount.getOrDefault(serialId, 0) + 1
        if (idToCount[serialId] == 2) res.add(root)
        return serialId
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}