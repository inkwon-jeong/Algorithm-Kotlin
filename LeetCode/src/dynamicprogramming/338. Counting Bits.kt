package countingbits

class Solution {
    fun countBits(n: Int): IntArray {
        if(n == 0) return intArrayOf(0)
        if(n == 1) return intArrayOf(0, 1)

        val d = IntArray(n + 1)
        d[0] = 0
        d[1] = 1

        var powerOfTwo = 1
        for(i in 2..n) {
            if(i == powerOfTwo * 2) {
                d[i] = 1
                powerOfTwo *= 2
            } else {
                d[i] = d[powerOfTwo] + d[i - powerOfTwo]
            }
        }

        return d
    }
}

