package topkfrequentwords

import java.util.*

class Solution {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val result: MutableList<String> = LinkedList()
        val map: MutableMap<String, Int> = HashMap()
        for (i in words.indices) {
            if (map.containsKey(words[i])) map[words[i]] = map[words[i]]!! + 1 else map[words[i]] = 1
        }

        val pq = PriorityQueue { (key, value): Map.Entry<String, Int>, (key1, value1): Map.Entry<String, Int> ->
            if (value == value1) key1.compareTo(
                key
            ) else value - value1
        }

        for (entry in map.entries) {
            pq.offer(entry)
            if (pq.size > k) pq.poll()
        }

        while (!pq.isEmpty()) result.add(0, pq.poll().key)

        return result
    }
}

