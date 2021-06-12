package numberof1bits

class Solution {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var answer = 0
        var num = n
        repeat(32) {
            val bit = num and 1
            if(bit == 1)
                answer++

            num = num shr 1
        }

        return answer
    }
}