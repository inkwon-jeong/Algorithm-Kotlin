package longestwordindictionary

class Solution {
    fun longestWord(words: Array<String>): String {
        val sortedWords = words.sorted()

        var longestWord = ""
        var longestLength = 0

        val root = Trie('*')
        sortedWords.forEach {
            var parent = root

            var canBeBuilt = true
            for (i in 0 until it.lastIndex) {
                val c = it[i]
                val child = parent.get(c)
                if(child == null) {
                    canBeBuilt = false
                    break
                }

                parent = child
            }

            if(canBeBuilt) {
                parent.put(it.last())

                if(longestLength < it.length) {
                    longestLength = it.length
                    longestWord = it
                }
            }
        }

        return longestWord
    }

    class Trie(c: Char) {
        private val children = hashMapOf<Char, Trie>()

        fun put(c: Char) {
            if(get(c) == null)
                children[c] = Trie(c)
        }

        fun get(c: Char): Trie? {
            return children[c]
        }
    }
}