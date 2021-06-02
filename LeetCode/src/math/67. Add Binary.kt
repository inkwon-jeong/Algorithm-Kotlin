package addbinary

class Solution {
    fun addBinary(a: String, b: String): String {
        var answer = ""
        var index1 = a.lastIndex
        var index2 = b.lastIndex

        var carry = 0
        while (index1 >= 0 || index2 >= 0) {
            val c1 = (a.getOrNull(index1--) ?: '0') - '0'
            val c2 = (b.getOrNull(index2--) ?: '0') - '0'

            when (carry + c1 + c2) {
                0 -> {
                    answer += '0'
                }
                1 -> {
                    carry = 0
                    answer += '1'
                }
                2 -> {
                    carry = 1
                    answer += '0'
                }
                3 -> {
                    carry = 1
                    answer += '1'
                }
            }
        }

        if(carry == 1)
            answer += '1'

        return answer.reversed()
    }
}