package hackerankhone

private fun main(){
    solution(longArrayOf(1,2,3,4))
}

fun solution(numbers: LongArray): Long {
    // Type your solution here
   return if (numbers.isEmpty()) 0 else numbers.max()
}

public fun LongArray.max(): Long {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}