package reversebits

class Solution {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var num = n
        var answer = 0

        repeat(32) {
            val bit = num and 1
            num = num shr 1
            answer = answer shl 1
            answer = answer or bit
        }

        return answer
    }
}

