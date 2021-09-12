package maximumproductofwordlength

import kotlin.math.max

class Solution {

    private lateinit var words: Array<String>
    private lateinit var bits: IntArray
    private var answer = 0

    fun maxProduct(words: Array<String>): Int {
        this.words = words
        this.bits = IntArray(words.size)

        for (index in words.indices) {
            val word = words[index]
            var bit = 0
            for (letter in word) {
                bit = bit or (1 shl (letter - 'a'))
            }
            bits[index] = bit
        }

        for (i in 0 until words.size - 1) {
            for (j in i + 1 until words.size) {
                if (bits[i] and bits[j] == 0)
                    answer = max(answer, words[i].length * words[j].length)
            }
        }

        return answer
    }
}

