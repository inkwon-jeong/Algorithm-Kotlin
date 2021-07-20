package pascalstriangle

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val answer = mutableListOf<List<Int>>()
        answer.add(listOf(1))

        var prev = answer.first()
        for(i in 2..numRows) {
            val array = IntArray(i)
            array[0] = 1
            array[array.lastIndex] = 1

            for(j in 1 until array.lastIndex) {
                array[j] = prev[j - 1] + prev[j]
            }

            val list = array.toList()
            answer.add(list)
            prev = list
        }

        return answer
    }
}

