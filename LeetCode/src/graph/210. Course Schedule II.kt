package courseschedule2

import java.util.*

class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val graph = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        val edges = IntArray(numCourses)

        prerequisites.forEach { (a, b) ->
            graph[b].add(a)
            edges[a]++
        }

        val list = mutableListOf<Int>()
        val queue: Queue<Int> = LinkedList()
        for (course in 0 until numCourses) {
            if (edges[course] == 0) {
                queue.add(course)
                list.add(course)
            }
        }

        while (queue.isNotEmpty()) {
            val course = queue.poll()
            for (next in graph[course]) {
                edges[next]--

                if (edges[next] == 0) {
                    queue.add(next)
                    list.add(next)
                }
            }
        }

        return if (list.size == numCourses) list.toIntArray()
        else intArrayOf()
    }
}

