package binarywatch

class Solution {

    private val set = mutableSetOf<String>()

    private val hours = listOf(1, 2, 4, 8)
    private val minutes = listOf(1, 2, 4, 8, 16, 32)

    private var totalTurnedOn = 0
    private var hoursTurnedOn = 0
    private var minutesTurnedOn = 0

    fun readBinaryWatch(turnedOn: Int): List<String> {
        totalTurnedOn = turnedOn

        for(i in 0..turnedOn) {
            if(i > 4)
                break

            hoursTurnedOn = i
            getHour()
        }

        return set.toList()
    }

    private fun getHour(turnedOn: Int = 0, start: Int = 0, hour: Int = 0) {
        if(hour > 11)
            return

        if(turnedOn == hoursTurnedOn) {
            minutesTurnedOn = totalTurnedOn - hoursTurnedOn
            getMinute(hour = hour)
            return
        }

        for(i in start..hours.lastIndex) {
            getHour(turnedOn + 1, i + 1, hour + hours[i])
        }
    }

    private fun getMinute(turnedOn: Int = 0, start: Int = 0, hour: Int, minute: Int = 0) {
        if(minute > 59)
            return

        if(turnedOn == minutesTurnedOn) {
            val str = String.format("%d:%02d", hour, minute)
            set.add(str)
            return
        }

        for(i in start..minutes.lastIndex) {
            getMinute(turnedOn + 1, i + 1, hour, minute + minutes[i])
        }
    }
}

