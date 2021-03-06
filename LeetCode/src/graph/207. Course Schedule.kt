package courseschedule

import java.util.*

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        val edges = IntArray(numCourses)

        prerequisites.forEach { (a, b) ->
            graph[b].add(a)
            edges[a]++
        }

        val queue: Queue<Int> = LinkedList()
        for(course in 0 until numCourses) {
            if(edges[course] == 0)
                queue.add(course)
        }

        while (queue.isNotEmpty()) {
            val course = queue.poll()
            for (next in graph[course]) {
                edges[next]--

                if(edges[next] == 0)
                    queue.add(next)
            }
        }

        return edges.all { it == 0 }
    }
}

