package integertoroman

class Solution {

    private val romans = listOf(
        1000 to 'M',
        500 to 'D',
        100 to 'C',
        50 to 'L',
        10 to 'X',
        5 to 'V',
        1 to 'I'
    )

    fun intToRoman(num: Int): String {
        var answer = ""
        var integer = num

        for(i in 0..romans.lastIndex step 2) {
            val (number, roman) = romans[i]
            val q = integer / number

            when {
                q == 9 -> {
                    answer += roman
                    answer += romans[i - 2].second
                }
                q == 4 -> {
                    answer += roman
                    answer += romans[i - 1].second
                }
                q >= 5 -> {
                    answer += romans[i - 1].second
                    repeat(q - 5) { answer += roman }
                }
                else -> {
                    repeat(q) { answer += roman }
                }
            }

            integer %= number
        }

        return answer
    }
}