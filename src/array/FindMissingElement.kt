package array

fun main(){

    val array = intArrayOf(90,100,101,98,54)
    println(solution2(array))

}

/**
* Write a function
*
* */


fun solution2(array: IntArray):Int{

    val numbs = hashSetOf<Int>()

    for (i in 1..array.size + 1){
        numbs.add(i)
    }

    array.forEach {
        numbs.remove(it.toInt())
    }


    return numbs.first()
}