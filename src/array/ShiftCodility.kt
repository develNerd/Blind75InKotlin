package array


fun main(){
    println(shift(intArrayOf(3, 8, 9, 7, 6)).toTypedArray().contentToString())
}

fun shift(array: IntArray):IntArray{
    val shiftedArray = IntArray(array.size)
    var end = array.size -1
    var currentIndex = 0

    for (i in end  downTo 0){
        shiftedArray[currentIndex] = array[end]
        currentIndex++
        end--
    }
    return shiftedArray
}