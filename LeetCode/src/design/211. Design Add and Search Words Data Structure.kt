package designaddandsearchwordsdatastructure

class WordDictionary() {

    /** Initialize your data structure here. */
    private val words = mutableListOf<String>()
    private var contains = false

    fun addWord(word: String) {
        words.add(word)
    }

    fun search(word: String): Boolean {
        contains = false
        val filtered = words.filter { it.length == word.length }
        search(word, 0, filtered)
        return contains
    }

    private fun search(word: String, index: Int, words: List<String>) {
        if(words.isEmpty())
            return

        if(index == word.length) {
            contains = true
            return
        }

        val filtered = words.filter { word[index] == '.' || it[index] == word[index]}
        search(word, index + 1, filtered)
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */

