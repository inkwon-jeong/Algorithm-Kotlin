package mycalendar2

import java.util.*

class MyCalendarTwo {

    private var map: TreeMap<Int, Int> = TreeMap()

    fun book(start: Int, end: Int): Boolean {
        map[start] = map.getOrDefault(start, 0) + 1
        map[end] = map.getOrDefault(end, 0) - 1
        var count = 0
        for ((_, value) in map) {
            count += value
            if (count > 2) {
                map[start] = map[start]!! - 1
                if (map[start] == 0) {
                    map.remove(start)
                }
                map[end] = map[end]!! + 1
                if (map[end] == 0) {
                    map.remove(end)
                }
                return false
            }
        }
        return true
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * var obj = MyCalendarTwo()
 * var param_1 = obj.book(start,end)
 */

