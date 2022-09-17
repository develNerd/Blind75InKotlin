package array

import kotlin.math.absoluteValue
import kotlin.math.pow


fun main(){
    val array = intArrayOf(2,1,3)
    println(solutionB(array,2))

    array.distinct() + 1
}

fun solutionB(A: IntArray, S: Int): Int {
    // write your code in Kotlin 1.3.11 (Linux)

    val regex = Regex("[0-9]")
    val subSets = subsets(A)?.filter { it.isNotEmpty() }!!.filter {
        println(it.sum()/it.size)
        (it.sum().absoluteValue/it.size).toInt() == S }

    println(subSets)
    if (subSets.size > 10.0.pow(9.0)){
        return  10.0.pow(9.0).toInt()
    }
    return subSets.size
}

fun subsets(nums: IntArray): List<List<Int>>? {
    val list: MutableList<List<Int>> = ArrayList()
    getMiniSubset(list, ArrayList(), nums, 0)
    return list
}

private fun getMiniSubset(list: MutableList<List<Int>>, resultList: MutableList<Int>, nums: IntArray, start: Int) {
    list.add(ArrayList(resultList))
    for (i in start until nums.size) {
        // add element
        resultList.add(nums[i])
        // Explore
        getMiniSubset(list, resultList, nums, i + 1)
        // remove
        resultList.removeAt(resultList.size - 1)
    }
}