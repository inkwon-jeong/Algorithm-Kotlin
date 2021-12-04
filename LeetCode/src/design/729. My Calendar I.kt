package mycalendar

class MyCalendar() {
    private val books = ArrayList<IntArray>()

    fun book(start: Int, end: Int): Boolean {
        for (b in books) {
            if (b[0].coerceAtLeast(start) < b[1].coerceAtMost(end))
                return false
        }
        books.add(intArrayOf(start, end))
        return true
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * var obj = MyCalendar()
 * var param_1 = obj.book(start,end)
 */

