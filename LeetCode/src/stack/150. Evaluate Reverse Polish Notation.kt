package evaluatereversepolishnotation

import java.util.*

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        tokens.forEach { token ->
            when (token) {
                "+" -> {
                    val second = stack.pop()
                    val first = stack.pop()
                    stack.push(first + second)
                }
                "-" -> {
                    val second = stack.pop()
                    val first = stack.pop()
                    stack.push(first - second)
                }
                "*" -> {
                    val second = stack.pop()
                    val first = stack.pop()
                    stack.push(first * second)
                }
                "/" -> {
                    val second = stack.pop()
                    val first = stack.pop()
                    stack.push(first / second)
                }
                else -> stack.push(token.toInt())
            }
        }

        return stack.pop()
    }
}

