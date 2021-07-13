package courseschedule

import java.util.*

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = Array<MutableList<Int>>(numCourses) { mutableListOf() }
        prerequisites.forEach { (a, b) ->
            graph[a].add(b)
        }

        for(course in 0 until numCourses) {
            val queue: Queue<Int> = LinkedList()
            val visited = BooleanArray(numCourses)
            queue.offer(course)
            visited[course] = true
            while (queue.isNotEmpty()) {
                val current = queue.poll()
                graph[current].forEach { next ->
                    if(next == course)
                        return false

                    if(!visited[next]) {
                        queue.offer(next)
                        visited[next] = true
                    }
                }
            }
        }

        return true
    }
}

