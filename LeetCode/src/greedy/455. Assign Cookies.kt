package assigncookies

class Solution {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        val children = g.sortedArray()
        val cookies = s.sortedArray()

        var answer = 0
        var childIndex = 0
        var cookieIndex = 0

        while (childIndex < children.size && cookieIndex < cookies.size) {
            val child = children[childIndex]
            val cookie = cookies[cookieIndex]

            if(child <= cookie) {
                answer++
                childIndex++
                cookieIndex++
            } else {
                cookieIndex++
            }
        }

        return answer
    }
}

