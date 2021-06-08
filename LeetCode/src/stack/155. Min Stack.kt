package minstack

class MinStack() {

    private val data = IntArray(30000)
    private var topIndex = -1

    fun push(`val`: Int) {
        data[++topIndex] = `val`
    }

    fun pop() {
        topIndex--
    }

    fun top(): Int {
        return data[topIndex]
    }

    fun getMin(): Int {
        var min = Int.MAX_VALUE
        for(i in 0..topIndex) {
            if(data[i] < min)
                min = data[i]
        }
        return min
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */

