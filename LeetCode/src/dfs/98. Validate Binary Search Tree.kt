package validatebinarysearchtree

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
    fun isValidBST(root: TreeNode?): Boolean {
        val nums = mutableListOf<Int>()
        inorder(nums, root)

        var num = nums[0]
        for(i in 1..nums.lastIndex) {
            if(num >= nums[i])
                return false
            num = nums[i]
        }

        return true
    }

    private fun inorder(nums: MutableList<Int>, node: TreeNode?) {
        if(node == null)
            return

        inorder(nums, node.left)
        nums.add(node.`val`)
        inorder(nums, node.right)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

