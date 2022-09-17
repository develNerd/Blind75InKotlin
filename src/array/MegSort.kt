package array

import kotlin.math.max


fun main(){


    println(intArrayOf(5,4,2,3,1
    ).copyOfRange(2,5).contentToString())
    //mergeSort(intArrayOf(7,2,6,3,9))
    println(mergeSort(intArrayOf(1,2,4,5,11,10)).contentToString())

}


fun mergeSort(array: IntArray):IntArray{

    if (array.size < 2) return array
    val middle = array.size / 2
    val left = mergeSort(array.copyOfRange(0,middle))
    val right = mergeSort(array.copyOfRange(middle,array.size))

    return merge(left,right)
}

fun merge(left:IntArray,right:IntArray):IntArray{
    var leftIndex = 0
    var rightIndex = 0
    var currentIndex = 0
    val result = IntArray(size = left.size.plus(right.size))

    while (leftIndex < left.size && rightIndex < right.size){
        if(left[leftIndex] > right[rightIndex]){
            result[currentIndex] = right[leftIndex]
            rightIndex += 1
        }else if (left[leftIndex] < right[rightIndex]){
            result[currentIndex] = left[leftIndex]
            leftIndex += 1
        }else{
            val leftElement =  left[leftIndex]
            result[currentIndex] = leftElement
            leftIndex += 1
            currentIndex++
            result[currentIndex] = right[rightIndex]
            rightIndex += 1
        }
        currentIndex++
    }

    if (leftIndex < left.size){
        (leftIndex until left.size).forEach {
            result[currentIndex] = left[it]
            currentIndex++
        }
    }

    if (rightIndex < right.size){
        (rightIndex until right.size).forEach {
            result[currentIndex] = right[it]
            currentIndex++
        }
    }

    return result

}