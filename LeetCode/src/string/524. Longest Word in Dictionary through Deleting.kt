package longestwordindictionarythroughdeleting

class Solution {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        var longest = ""
        for (word in dictionary) {
            var i = 0
            for (c in s.toCharArray())
                if (i < word.length && c == word[i])
                    i++

            if (i == word.length && word.length >= longest.length)
                if (word.length > longest.length || word < longest)
                    longest = word
        }
        return longest
    }
}

