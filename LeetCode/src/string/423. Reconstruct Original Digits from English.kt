package string

class Solution {
    fun originalDigits(s: String): String {
        val count = IntArray(10)
        for (element in s) {
            if (element == 'z') count[0]++
            if (element == 'w') count[2]++
            if (element == 'x') count[6]++
            if (element == 's') count[7]++ //7-6
            if (element == 'g') count[8]++
            if (element == 'u') count[4]++
            if (element == 'f') count[5]++ //5-4
            if (element == 'h') count[3]++ //3-8
            if (element == 'i') count[9]++ //9-8-5-6
            if (element == 'o') count[1]++ //1-0-2-4
        }
        count[7] -= count[6]
        count[5] -= count[4]
        count[3] -= count[8]
        count[9] = count[9] - count[8] - count[5] - count[6]
        count[1] = count[1] - count[0] - count[2] - count[4]
        val sb = StringBuilder()
        for (i in 0..9) {
            for (j in 0 until count[i]) {
                sb.append(i)
            }
        }
        return sb.toString()
    }
}