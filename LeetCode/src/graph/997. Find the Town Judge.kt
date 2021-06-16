package findthetownjudge

class Solution {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val truster = IntArray(n)
        val trustee = IntArray(n)

        trust.forEach { (a, b) ->
            truster[a - 1]++
            trustee[b - 1]++
        }

        val index1 = truster.indexOf(0)
        val index2 = trustee.indexOf(n - 1)

        return if (index1 != -1 && index1 == index2) index1 + 1
        else -1
    }
}

