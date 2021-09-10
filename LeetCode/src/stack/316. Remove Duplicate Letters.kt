package removeduplicateletters

import java.util.*

class Solution {
    fun removeDuplicateLetters(s: String): String {
        val frequency = IntArray(26)
        val visited = BooleanArray(26)
        s.forEach { c -> frequency[c - 'a']++ }

        val stack = Stack<Char>()
        for (c in s) {
            val index = c - 'a'
            frequency[index]--

            if (visited[index]) continue

            while (stack.isNotEmpty() && c < stack.peek() && frequency[stack.peek() - 'a'] != 0)
                visited[stack.pop() - 'a'] = false

            stack.push(c)
            visited[index] = true
        }

        var answer = ""
        while (stack.isNotEmpty())
            answer = "${stack.pop()}$answer"

        return answer
    }
}

