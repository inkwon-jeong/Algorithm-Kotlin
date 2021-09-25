package longestabsolutefilepath

import java.util.*
import kotlin.math.max

class Solution {
    fun lengthLongestPath(input: String): Int {
        var length = 0
        var maxLength = 0
        val dirs = input.split("\n")
        val stack = Stack<Directory>()
        for (dir in dirs) {
            val directory = Directory(getName(dir), getLevel(dir))
            while (stack.isNotEmpty() && stack.peek().level >= directory.level) {
                length -= stack.pop().name.length
            }
            stack.push(directory)
            length += directory.name.length
            if (directory.isFile)
                maxLength = max(maxLength, length)
        }

        return maxLength
    }

    private fun getName(dir: String): String {
        return dir.replace("\t", "")
    }

    private fun getLevel(dir: String): Int {
        return dir.split("\t").size
    }

    class Directory(
        name: String,
        val level: Int
    ) {
        val name =
            if (level == 1) name
            else "/$name"

        val isFile = name.contains(".")
    }
}

