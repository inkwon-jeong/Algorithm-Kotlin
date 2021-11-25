package implementmagicdictionary


class MagicDictionary() {

    private val map: MutableMap<String, MutableList<CharArray>> = mutableMapOf()

    fun buildDict(dictionary: Array<String>) {
        for (s in dictionary) {
            for (i in s.indices) {
                val key = s.substring(0, i) + s.substring(i + 1)
                val pair = charArrayOf(i.toChar(), s[i])
                val `val`: MutableList<CharArray> = map[key] ?: mutableListOf()
                `val`.add(pair)
                map[key] = `val`
            }
        }
    }

    fun search(word: String): Boolean {
        for (i in word.indices) {
            val key: String = word.substring(0, i) + word.substring(i + 1)
            if (map.containsKey(key)) {
                for (pair in map[key]!!) {
                    if (pair[0] == i.toChar() && pair[1] != word[i]) return true
                }
            }
        }
        return false
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * var obj = MagicDictionary()
 * obj.buildDict(dictionary)
 * var param_2 = obj.search(searchWord)
 */

