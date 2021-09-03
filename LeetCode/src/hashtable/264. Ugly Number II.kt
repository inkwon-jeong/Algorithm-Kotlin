package uglynumber2

import java.util.*

class Solution {
    fun nthUglyNumber(n: Int): Int {
        if (n == 1)
            return 1

        val hashSet = hashSetOf(1)
        val priorityQueue = PriorityQueue<Int>()
        priorityQueue.add(1)

        var count = 0
        var number = 0
        while (count < n) {
            count++
            number = priorityQueue.poll()

            if (!hashSet.contains(number * 2) &&
                Int.MAX_VALUE / 2 >= number
            ) {
                priorityQueue.add(number * 2)
                hashSet.add(number * 2)
            }

            if (!hashSet.contains(number * 3) &&
                Int.MAX_VALUE / 3 >= number
            ) {
                priorityQueue.add(number * 3)
                hashSet.add(number * 3)
            }

            if (!hashSet.contains(number * 5) &&
                Int.MAX_VALUE / 5 >= number
            ) {
                priorityQueue.add(number * 5)
                hashSet.add(number * 5)
            }
        }

        return number
    }
}