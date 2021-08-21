package constructbinarytreefrompreorderandinordertraversal

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

    private var preorderIndex = 0
    private lateinit var inorderIndexMap: HashMap<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        inorderIndexMap = hashMapOf()
        inorder.forEachIndexed { index, `val` ->
            inorderIndexMap[`val`] = index
        }
        return buildTree(preorder, 0, preorder.lastIndex)
    }

    private fun buildTree(preorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end)
            return null

        val rootVal = preorder[preorderIndex++]
        val rootNode = TreeNode(rootVal)

        rootNode.left = buildTree(preorder, start, inorderIndexMap[rootVal]!! - 1)
        rootNode.right = buildTree(preorder, inorderIndexMap[rootVal]!! + 1, end)

        return rootNode
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

