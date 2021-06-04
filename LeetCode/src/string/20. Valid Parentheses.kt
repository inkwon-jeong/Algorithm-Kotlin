package validparentheses

import java.lang.Exception
import java.util.*

class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        try {
            s.forEach { c ->
                when (c) {
                    '(', '[', '{' -> stack.push(c)
                    ')' -> {
                        if (stack.pop() != '(')
                            return false
                    }
                    ']' -> {
                        if (stack.pop() != '[')
                            return false
                    }
                    '}' -> {
                        if (stack.pop() != '{')
                            return false
                    }
                }
            }
        } catch (e: Exception) {
            return false
        }

        return stack.isEmpty()
    }
}