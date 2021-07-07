package implementtrie

class Trie() {

    /** Initialize your data structure here. */
    private val root = Node('*')

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var parent = root
        word.forEachIndexed { index, c ->
            if(index == word.lastIndex)
                parent.put(c, true)
            else
                parent.put(c)

            parent = parent.get(c)!!
        }
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var parent = root
        word.forEach { c ->
            if(parent.get(c) == null)
                return false

            parent = parent.get(c)!!
        }

        return parent.isLast
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var parent = root
        prefix.forEach { c ->
            if(parent.get(c) == null)
                return false

            parent = parent.get(c)!!
        }

        return true
    }

    class Node(val c: Char, val isLast: Boolean = false) {
        private val children = mutableMapOf<Char, Node>()

        fun get(c: Char): Node? {
            return children[c]
        }

        fun put(c: Char, isLast: Boolean = false) {
            if(get(c) == null || isLast)
                children[c] = Node(c, isLast)
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
