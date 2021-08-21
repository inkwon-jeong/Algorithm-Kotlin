package constructbinarytreefrominorderandpostordertraversal

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

    private var postorderIndex = 0
    private lateinit var inorderIndexMap: HashMap<Int, Int>

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        postorderIndex = postorder.lastIndex
        inorderIndexMap = hashMapOf()
        inorder.forEachIndexed { index, `val` ->
            inorderIndexMap[`val`] = index
        }
        return buildTree(postorder, 0, postorder.lastIndex)
    }

    private fun buildTree(postorder: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end)
            return null

        val rootVal = postorder[postorderIndex--]
        val rootNode = TreeNode(rootVal)

        rootNode.right = buildTree(postorder, inorderIndexMap[rootVal]!! + 1, end)
        rootNode.left = buildTree(postorder, start, inorderIndexMap[rootVal]!! - 1)

        return rootNode
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
