package longesetcommonprefix

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var answer = ""
        var index = 0
        loop@ while (true) {
            val c = strs.first().getOrNull(index) ?: break
            for(i in 1..strs.lastIndex) {
                val d = strs[i].getOrNull(index) ?: break@loop
                if(c != d) break@loop
            }
            answer += c
            index++
        }

        return answer
    }
}