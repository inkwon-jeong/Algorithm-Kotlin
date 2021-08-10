package restoreipaddresses

class Solution {

    private lateinit var answer: MutableList<String>

    fun restoreIpAddresses(s: String): List<String> {
        answer = mutableListOf()
        restoreIpAddresses(s, 0, mutableListOf())
        return answer
    }

    private fun restoreIpAddresses(s: String, start: Int, address: MutableList<Int>) {
        if (address.size == 4) {
            if (start == s.length)
                answer.add(address.joinToString(separator = "."))
            return
        }

        loop@ for (end in start + 1..s.length) {
            val integers = s.substring(start, end).toInt()
            when {
                integers == 0 -> {
                    address.add(integers)
                    restoreIpAddresses(s, end, address)
                    address.removeAt(address.lastIndex)
                    break@loop
                }
                integers in 1..255 -> {
                    address.add(integers)
                    restoreIpAddresses(s, end, address)
                    address.removeAt(address.lastIndex)
                }
                integers > 255 -> break@loop
            }
        }
    }
}

