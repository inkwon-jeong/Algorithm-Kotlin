package mapsumpairs

class MapSum {

    class TrieNode {
        var children: MutableMap<Char, TrieNode> = HashMap()
        var isWord: Boolean = false
        var value: Int = 0
    }

    var root: TrieNode = TrieNode()

    fun insert(key: String, `val`: Int) {
        var curr = root
        for (c in key.toCharArray()) {
            var next = curr.children[c]
            if (next == null) {
                next = TrieNode()
                curr.children[c] = next
            }
            curr = next
        }
        curr.isWord = true
        curr.value = `val`
    }

    fun sum(prefix: String): Int {
        var curr = root
        for (c in prefix.toCharArray()) {
            val next = curr.children[c] ?: return 0
            curr = next
        }
        return dfs(curr)
    }

    private fun dfs(root: TrieNode?): Int {
        var sum = 0
        for (c in root!!.children.keys) {
            sum += dfs(root.children[c])
        }
        return sum + root.value
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * var obj = MapSum()
 * obj.insert(key,`val`)
 * var param_2 = obj.sum(prefix)
 */

