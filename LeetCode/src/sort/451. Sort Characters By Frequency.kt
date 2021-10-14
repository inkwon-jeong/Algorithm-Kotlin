package sortcharactersbyfrequency


class Solution {
    fun frequencySort(s: String): String {
        val map: MutableMap<Char, Int> = HashMap()
        for (c in s.toCharArray()) map[c] = map.getOrDefault(c, 0) + 1

        val bucket = Array<MutableList<Char>>(s.length + 1) { mutableListOf() }
        for (key in map.keys) {
            val frequency = map[key]!!
            if (bucket.getOrNull(frequency) == null) bucket[frequency] = ArrayList()
            bucket[frequency].add(key)
        }

        val sb = StringBuilder()
        for (pos in bucket.indices.reversed()) if (bucket.getOrNull(pos) != null) {
            for (c in bucket[pos]) {
                for (i in 0 until pos) {
                    sb.append(c)
                }
            }
        }

        return sb.toString()
    }
}

