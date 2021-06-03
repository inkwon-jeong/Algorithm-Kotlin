package validpalindrome

class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.replace("[^a-zA-Z]".toRegex(), "").toLowerCase()
        return str == str.reversed()
    }
}