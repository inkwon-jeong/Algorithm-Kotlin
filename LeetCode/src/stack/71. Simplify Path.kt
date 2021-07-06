package simplifypath

import java.util.*

class Solution {
    fun simplifyPath(path: String): String {
        val stack = Stack<String>()
        val files = path.split("/")

        files.forEach {
            when (it) {
                "", "." -> {}
                ".." -> if(stack.isNotEmpty()) stack.pop()
                else -> stack.push(it)
            }
        }

        var answer = ""
        while (stack.isNotEmpty()) {
            val file = stack.pop()
            answer = "/$file$answer"
        }

        return answer.ifEmpty { "/" }
    }
}

