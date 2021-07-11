package generateparentheses

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val d = Array<List<String>>(n + 1) { listOf() }
        d[1] = listOf("()")

        for (i in 2..n) {
            val set = mutableSetOf<String>()
            for (parenthesis in d[i - 1]) {
                set.add("($parenthesis)")
            }
            for (j in 1..i / 2) {
                for(p1 in d[j]) {
                    for(p2 in d[i - j]) {
                        set.add(("$p1$p2"))
                        set.add(("$p2$p1"))
                    }
                }
            }

            d[i] = set.toList().sorted()
        }

        return d[n]
    }
}

