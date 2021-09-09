package superuglynumber

import java.util.*

class Solution {
    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val ugly = IntArray(n)

        val pq: PriorityQueue<Num> = PriorityQueue<Num>()
        for (i in primes.indices) pq.add(Num(primes[i], 1, primes[i]))
        ugly[0] = 1

        for (i in 1 until n) {
            ugly[i] = pq.peek().`val`
            while (pq.peek().`val` == ugly[i]) {
                val nxt: Num = pq.poll()
                pq.add(Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p))
            }
        }

        return ugly[n - 1]
    }

    private class Num(
        var `val`: Int,
        var idx: Int,
        var p: Int
    ) : Comparable<Num> {
        override fun compareTo(other: Num): Int {
            return `val` - other.`val`
        }
    }
}

