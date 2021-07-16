package repeateddnasequences

class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if(s.length < 10)
            return listOf()

        var start = 0
        var end = 10
        val set = mutableSetOf<String>()
        val answer = mutableSetOf<String>()
        while (end <= s.length) {
            val substring = s.substring(start++, end++)
            if(set.contains(substring))
                answer.add(substring)
            else
                set.add(substring)
        }

        return answer.toList()
    }
}

