package eliminationgame

class Solution {
    fun lastRemaining(n: Int): Int {
        var isLeft = true
        var remaining = n
        var step = 1
        var head = 1
        while (remaining > 1) {
            if (isLeft || remaining % 2 == 1) {
                head += step
            }
            remaining /= 2
            step *= 2
            isLeft = !isLeft
        }
        return head
    }
}

