package strings

import java.util.regex.Matcher


fun main(){

    val mom = "  fqabcdeee ghfjkddddlopiugfds     "
    val regex = Regex("([a-z])\\1+")
    val rGX = Regex("\\s+")

    val m1 = rGX.findAll(mom)
    println(m1.toMutableList().size)

    val m = mom.split(regex)

    println("3,4.5".split(",","."))

    val lengths = m.map(String::length).toTypedArray()
    for (i in lengths.indices){
        when (i) {
            0 -> {
                lengths[i] = lengths[i] + 1
            }
            lengths.size - 1 -> {
                lengths[i] = lengths[i] + 1
            }
            else -> {
                lengths[i] = lengths[i] + 2
            }
        }
    }
    println(m)
    println(lengths.maxOrNull())
    println(lengthOfLongestSubstring(mom))
}


fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    var ans = 0
    val map: MutableMap<Char, Int> = HashMap() // current index of character
    // try to extend the range [i, j]
    var j = 0
    var i = 0
    while (j < n) {
        if (map.containsKey(s[j])) {
            i = Math.max(map[s[j]]!!, i)
        }
        ans = Math.max(ans, j - i + 1)
        map[s[j]] = j + 1
        j++
    }
    return ans
}


fun solution(N: Int): Int {
    val zeroAndOnes = Integer.toBinaryString(N)
        .replace(Regex("0+$"), "")

    val zeros = zeroAndOnes.split(Regex("1+"))

    val lengths = zeros.map(String::length)
        .filter { it > 0 }

    return lengths.maxOrNull()!!.or(0)
}