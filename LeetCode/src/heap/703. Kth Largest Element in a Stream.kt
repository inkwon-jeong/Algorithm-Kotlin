package kthlargestelementinastream

class KthLargest(private val k: Int, nums: IntArray) {

    private val heap = mutableListOf<Int>()

    init {
        nums.forEach { addAndSort(it) }
    }

    private fun addAndSort(`val`: Int) {
        if(heap.isEmpty()) {
            heap.add(`val`)
            return
        }

        var start = 0
        var end = heap.lastIndex

        loop@ while (start <= end) {
            val mid = (start + end) / 2
            when {
                heap[mid] < `val` -> end = mid - 1
                heap[mid] > `val` -> start = mid + 1
                else -> {
                    start = mid
                    break@loop
                }
            }
        }

        heap.add(start, `val`)
    }

    fun add(`val`: Int): Int {
        addAndSort(`val`)
        return heap[k - 1]
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */

