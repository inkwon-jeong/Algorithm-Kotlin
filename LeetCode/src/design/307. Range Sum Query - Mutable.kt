package rangesumquerymutable

class NumArray(private val nums: IntArray) {

    private val d = IntArray(nums.size)

    init {
        var sum = 0
        nums.forEachIndexed { index, num ->
            sum += num
            d[index] = sum
        }
    }

    fun update(index: Int, `val`: Int) {
        val diff = nums[index] - `val`

        nums[index] = `val`
        for (i in index until nums.size)
            d[i] = d[i] - diff
    }

    fun sumRange(left: Int, right: Int): Int {
        return if (left == 0) d[right]
        else d[right] - d[left - 1]
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * var obj = NumArray(nums)
 * obj.update(index,`val`)
 * var param_2 = obj.sumRange(left,right)
 */