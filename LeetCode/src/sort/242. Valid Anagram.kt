package validanagram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val chars1 = s.toList().sorted()
        val chars2 = t.toList().sorted()

        return chars1 == chars2
    }
}

