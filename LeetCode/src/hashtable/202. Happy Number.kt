package happynumber

class Solution {
    fun isHappy(n: Int): Boolean {
        val set = mutableSetOf<Int>()

        var number = n
        while (number != 1) {
            if(set.contains(number))
                return false

            set.add(number)
            var sum = 0
            while (number > 0) {
                val mod = number % 10
                sum += mod * mod
                number /= 10
            }
            number = sum
        }

        return true
    }
}

