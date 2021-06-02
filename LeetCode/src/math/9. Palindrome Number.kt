package palindromenumber

class Solution {
    fun isPalindrome(x: Int): Boolean {
        val number = x.toString()
        val reversed = number.reversed()

        return number == reversed
    }
}