package reversevowelsofastring

class Solution {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()
        val vowels = setOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        var left = 0
        var right = s.lastIndex

        while (left < right) {
            val c1 = chars[left]
            val c2 = chars[right]

            if(!vowels.contains(c1)) {
                left++
                continue
            }

            if(!vowels.contains(c2)) {
                right--
                continue
            }

            chars[left++] = c2
            chars[right--] = c1
        }

        return String(chars)
    }
}

