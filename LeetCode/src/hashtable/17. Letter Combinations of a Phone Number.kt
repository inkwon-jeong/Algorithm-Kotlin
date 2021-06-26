package lettercombinationsofaphonenumber

class Solution {

    private val numberToLetter = mapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z')
    )

    private val answer = mutableListOf<String>()

    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty())
            return listOf()

        val letters = digits.mapNotNull { numberToLetter[it] }
        permutation(letters, 0, "")
        return answer
    }

    private fun permutation(letters: List<List<Char>>, digit: Int, str: String) {
        if(digit > letters.lastIndex) {
            answer.add(str)
            return
        }

        val chars = letters[digit]
        chars.forEach {
            permutation(letters, digit + 1, "$str$it")
        }
    }
}

