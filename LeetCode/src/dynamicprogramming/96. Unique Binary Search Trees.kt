package uniquebinarysearchtrees

class Solution {
    fun numTrees(n: Int): Int {
        val d = IntArray(n + 1)
        d[0] = 1
        d[1] = 1

        for(i in 2..n) {
            var sum = 0
            for(j in 1..i) {
                sum += (d[j - 1] * d[i - j])
            }
            d[i] = sum
        }

        return d[n]
    }
}

