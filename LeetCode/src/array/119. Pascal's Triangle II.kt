package pascalstriangle2

class Solution {
    fun getRow(rowIndex: Int): List<Int> {
        val answer = mutableListOf<List<Int>>()
        answer.add(listOf(1))

        var prev = answer.first()
        for(i in 1..rowIndex) {
            val array = IntArray(i + 1)
            array[0] = 1
            array[array.lastIndex] = 1

            for(j in 1 until array.lastIndex) {
                array[j] = prev[j - 1] + prev[j]
            }

            val list = array.toList()
            answer.add(list)
            prev = list
        }

        return answer[rowIndex]
    }
}
