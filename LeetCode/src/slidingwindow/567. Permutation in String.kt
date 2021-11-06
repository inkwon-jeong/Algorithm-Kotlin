package permutationinstring


class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        if (len1 > len2) return false

        val count = IntArray(26)
        for (i in 0 until len1) {
            count[s1[i] - 'a']++
            count[s2[i] - 'a']--
        }
        if (allZero(count)) return true

        for (i in len1 until len2) {
            count[s2[i] - 'a']--
            count[s2[i - len1] - 'a']++
            if (allZero(count)) return true
        }

        return false
    }

    private fun allZero(count: IntArray): Boolean {
        for (i in 0..25) {
            if (count[i] != 0) return false
        }
        return true
    }
}

