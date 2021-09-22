package insertdeletegetrandomo1

class RandomizedSet() {

    /** Initialize your data structure here. */
    private val map = mutableMapOf<Int, Int>()
    private val list = mutableListOf<Int>()

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    fun insert(`val`: Int): Boolean {
        return if (map.contains(`val`)) false
        else {
            map[`val`] = list.size
            list.add(`val`)
            true
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    fun remove(`val`: Int): Boolean {
        return if (map.contains(`val`)) {
            val removeIndex = map[`val`]!!
            val lastIndex = list.lastIndex
            val lastVal = list.last()

            map[lastVal] = removeIndex
            map[`val`] = lastIndex

            list[removeIndex] = lastVal
            list[lastIndex] = `val`

            list.removeAt(lastIndex)
            map.remove(`val`)
            true
        } else false
    }

    /** Get a random element from the set. */
    fun getRandom(): Int {
        return list.random()
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */

