package excelsheetcolumnnumber

class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var number = 0
        columnTitle.forEachIndexed { index, c ->
            val digit = c - 'A' + 1
            number += pow(columnTitle.lastIndex - index) * digit
        }

        return number
    }

    private fun pow(count: Int): Int {
        var result = 1
        repeat(count) { result *= 26 }
        return result
    }
}

