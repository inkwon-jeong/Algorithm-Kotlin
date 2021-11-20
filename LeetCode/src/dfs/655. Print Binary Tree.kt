package printbinarytree

import java.util.*
import kotlin.math.pow

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
    fun printTree(root: TreeNode?): List<List<String>> {
        val res: MutableList<MutableList<String>> = LinkedList()
        val height = root?.let { getHeight(it) } ?: 1
        val columns = (2.0.pow(height.toDouble()) - 1).toInt()
        val row: MutableList<String> = ArrayList()
        for (i in 0 until columns) row.add("")
        for (i in 0 until height) res.add(ArrayList(row))
        populateRes(root, res, 0, height, 0, columns - 1)
        return res
    }

    private fun populateRes(root: TreeNode?, res: List<MutableList<String>>, row: Int, totalRows: Int, i: Int, j: Int) {
        if (row == totalRows || root == null) return
        res[row][(i + j) / 2] = root.`val`.toString()
        populateRes(root.left, res, row + 1, totalRows, i, (i + j) / 2 - 1)
        populateRes(root.right, res, row + 1, totalRows, (i + j) / 2 + 1, j)
    }

    private fun getHeight(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + Math.max(getHeight(root.left), getHeight(root.right))
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}