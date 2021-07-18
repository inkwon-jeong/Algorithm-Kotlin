package bullsandcows

class Solution {
    fun getHint(secret: String, guess: String): String {
        val map = mutableMapOf<Char, Int>()
        val set = mutableSetOf<Int>()
        var bulls = 0
        var cows = 0

        for (i in secret.indices) {
            if (secret[i] == guess[i]) {
                bulls++
                continue
            }

            set.add(i)
            map[secret[i]] = map.getOrDefault(secret[i], 0) + 1
        }

        set.forEach { index ->
            if(map.contains(guess[index])) {
                cows++
                map[guess[index]] = map[guess[index]]!! - 1
                if(map[guess[index]] == 0)
                    map.remove(guess[index])
            }
        }

        return "${bulls}A${cows}B"
    }
}

