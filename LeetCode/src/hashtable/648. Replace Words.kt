package replacewords

class Solution {
    fun replaceWords(dict: List<String>?, sentence: String): String {
        if (dict == null || dict.isEmpty()) return sentence
        val set: MutableSet<String> = HashSet()
        for (s in dict) set.add(s)
        val sb = StringBuilder()
        val words = sentence.split("\\s+".toRegex()).toTypedArray()
        for (word in words) {
            var prefix = ""
            for (i in 1..word.length) {
                prefix = word.substring(0, i)
                if (set.contains(prefix)) break
            }
            sb.append(" $prefix")
        }
        return sb.deleteCharAt(0).toString()
    }
}

