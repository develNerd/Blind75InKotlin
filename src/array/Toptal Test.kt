package array


fun main(){
    val array = intArrayOf(1, 2, 3)
    println(solution(array))
}

fun solution(A: IntArray):Int{
    val end = A.max()
    val set: MutableSet<Int> = HashSet()
    for (a in A) {
        if (a > 0) {
            set.add(a)
        }
    }
    if (set.isEmpty()){
        return 1
    }
    val start= set.min()

    for (i in start..end + 1) {
        if (!set.contains(i)) {
            return i
        }
    }
    return 1
}