package rangesumqueryimmutable

class NumArray(val nums: IntArray) {

    val d = IntArray(nums.size)

    init {
        d[0] = nums[0]
        for(i in 1..nums.lastIndex) {
            d[i] = nums[i] + d[i - 1]
        }
    }

    fun sumRange(left: Int, right: Int): Int {
        val not = if(left == 0)  0 else d[left - 1]
        return d[right] - not
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * var param_1 = obj.sumRange(left,right)
 */

