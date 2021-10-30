package complexnumbermultiplication

class Solution {
    fun complexNumberMultiply(num1: String, num2: String): String {
        val array1 = num1.split("+")
        val array2 = num2.split("+")
        val a1 = array1[0].toInt()
        val b1 = array1[1].replace("i", "").toInt()

        val a2 = array2[0].toInt()
        val b2 = array2[1].replace("i", "").toInt()

        val a1a2 = a1 * a2
        val b1b2 = b1 * b2
        val a1b2a2b1 = a1 * b2 + b1 * a2

        val aFinal = (a1a2 + -1 * b1b2).toString() + ""
        val bFinal = a1b2a2b1.toString() + "i"
        return "$aFinal+$bFinal"
    }
}

