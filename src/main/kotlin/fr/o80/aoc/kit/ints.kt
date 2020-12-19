package fr.o80.aoc.kit

fun <T: Comparable<T>>Iterable<T>.minAndMaxOrNull(): Pair<T, T>? {
    return this.iterator().minAndMaxOrNull()
}

fun <T: Comparable<T>> Sequence<T>.minAndMaxOrNull(): Pair<T, T>? {
    return this.iterator().minAndMaxOrNull()
}

fun <T: Comparable<T>> Iterator<T>.minAndMaxOrNull(): Pair<T, T>? {
    var min: T? = null
    var max: T? = null

    this.forEach {
        if (min == null || it < min!!) {
            min = it
        }
        if (max == null || it > max!!) {
            max = it
        }
    }

    return if (min == null) {
        null
    } else {
        Pair(min!!, max!!)
    }
}

fun String.parseInt(radix: Int): Long {
    return java.lang.Long.parseLong(this, radix)
}

fun String.tryToInt(): Int? {
    return try {
        this.toInt()
    } catch (e: Exception) {
        null
    }
}

fun String.tryToLong(): Long? {
    return try {
        this.toLong()
    } catch (e: Exception) {
        null
    }
}
