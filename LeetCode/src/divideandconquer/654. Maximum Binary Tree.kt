package maximumbinarytree

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
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        val stack: Deque<TreeNode> = LinkedList()
        for (i in nums.indices) {
            val curr = TreeNode(nums[i])
            while (!stack.isEmpty() && stack.peek().`val` < nums[i]) {
                curr.left = stack.pop()
            }
            if (!stack.isEmpty()) {
                stack.peek().right = curr
            }
            stack.push(curr)
        }

        return if (stack.isEmpty()) null else stack.removeLast()
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

