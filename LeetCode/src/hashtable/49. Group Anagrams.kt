package groupanagrams

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<List<Char>, MutableList<String>>()
        strs.forEach {
            val list = it.toList().sorted()
            if(map.contains(list)) {
                map[list]?.add(it)
            } else {
                map[list] = mutableListOf(it)
            }
        }

        return map.values.toList()
    }
}

