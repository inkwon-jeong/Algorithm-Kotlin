package fractionadditionandsubtraction

import java.util.*

class Solution {
    fun fractionAddition(expression: String): String {
        val sc = Scanner(expression).useDelimiter("/|(?=[-+])")
        var A = 0
        var B = 1
        while (sc.hasNext()) {
            val a: Int = sc.nextInt()
            val b: Int = sc.nextInt()
            A = A * b + a * B
            B *= b
            val g = gcd(A, B)
            A /= g
            B /= g
        }
        return "$A/$B"
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (a != 0) gcd(b % a, a) else Math.abs(b)
    }
}

