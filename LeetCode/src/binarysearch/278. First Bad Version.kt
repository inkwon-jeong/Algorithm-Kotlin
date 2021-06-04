package firstbadversion

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var answer = 0
        var start = 1
        var end = n

        while (start <= end) {
            val mid = start + (end - start) / 2
            if(isBadVersion(mid)) {
                answer = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return answer
    }
}

abstract class VersionControl {
    abstract fun firstBadVersion(n: Int) : Int
    fun isBadVersion(version: Int): Boolean = true
}

