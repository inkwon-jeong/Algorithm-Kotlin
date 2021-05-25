package reverseinteger

import kotlin.math.absoluteValue

class Solution {
    fun reverse(x: Int): Int {
        val isNegative = x < 0

        val input = x.absoluteValue.toString()
        val output = input.reversed()

        val answer = output.toIntOrNull()

        return when {
            answer == null -> 0
            isNegative -> -answer
            else -> answer
        }
    }
}
