package binarysearchtreeiterator

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
class BSTIterator(root: TreeNode?) {

    private val list = mutableListOf<TreeNode>()
    private var index = 0

    init {
        inorder(root)
    }

    private fun inorder(node: TreeNode?) {
        if(node == null)
            return

        inorder(node.left)
        list.add(node)
        inorder(node.right)
    }

    fun next(): Int {
        return list[index++].`val`
    }

    fun hasNext(): Boolean {
        return list.getOrNull(index) != null
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */

