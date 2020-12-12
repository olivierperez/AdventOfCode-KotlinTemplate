package fr.o80.aoc.kit.table

class Table<T>(
    val width: Int,
    val height: Int
) {

    private val data = MutableList<T?>(width * height) { null }

    operator fun get(x: Int, y: Int): T? {
        checkBounds(x, y)
        return data[x + y * width]
    }

    operator fun set(x: Int, y: Int, value: T) {
        checkBounds(x, y)
        data[x + y * width] = value
    }

    fun debug() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                print(" " + this[x, y]!!)
            }
            println()
        }
    }

    private fun checkBounds(x: Int, y: Int) {
        if (isOutOfBounds(x, y)) {
            throw IndexOutOfBoundsException("Cell [$x;$y] out of ($width, $height)")
        }
    }

    fun getOrNull(x: Int, y: Int): T? =
        if (isOutOfBounds(x, y)) null
        else data[x + y * width]

    private fun isOutOfBounds(x: Int, y: Int) =
        x < 0 || y < 0 || x > width - 1 || y > height - 1

    fun count(predicate: (T?) -> Boolean): Int {
        return data.count(predicate)
    }

    fun forEachIndexed(block: (Int, Int, T?) -> Unit) {
        for (y in 0 until height) {
            for (x in 0 until width) {
                block(x, y, get(x, y))
            }
        }
    }

}