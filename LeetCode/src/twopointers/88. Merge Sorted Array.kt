package mergesortedarray

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val array = Array(nums1.size) { 0 }

        var index = 0
        var index1 = 0
        var index2 = 0

        while (index1 < m && index2 < n) {
            val num1 = nums1.getOrElse(index1) { Int.MAX_VALUE }
            val num2 = nums2.getOrElse(index2) { Int.MAX_VALUE }

            when {
                num1 > num2 -> {
                    array[index++] = num2
                    index2++
                }
                num2 > num1 -> {
                    array[index++] = num1
                    index1++
                }
                else -> {
                    array[index++] = num1
                    array[index++] = num2
                    index1++
                    index2++
                }
            }
        }

        while (index1 < m) {
            array[index++] = nums1[index1++]
        }

        while (index2 < n) {
            array[index++] = nums2[index2++]
        }

        array.forEachIndexed { i, num ->
            nums1[i] = num
        }
    }
}

