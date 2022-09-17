package bonus

import array.mergeSort
import kotlin.math.absoluteValue

class Api(){
    companion object{
        public var does = ""
    }
}

/**
*
 * if you are given an int array [3,1,11,5,10,19]. Find the index of target 10
 * if the array was sorted.
 *
 * solution
 *
 * is to try to sort and while sorting find the target and it's index
 *
* */

data class Target(var targetValue:Int,var index:Int = 0)

/*fun main(){

    val targetObject = Target(17,0)
    val array = intArrayOf(3,1,11,5,10,19,17)
    println(mergeSortFindTarget(array,targetObject).contentToString())
    println(targetObject.index)
}*/

/**
 * Time complexity = O(nlogn)
 * */
fun mergeSortFindTarget(array: IntArray,target: Target):IntArray{

    Api()
    if (array.size == 1) return array

    val middle = array.size / 2
    val left = mergeSortFindTarget(array.copyOfRange(0,middle),target)
    val right = mergeSortFindTarget(array.copyOfRange(middle,array.size),target)

    return merge(left,right,target)

}

fun merge(left:IntArray,right:IntArray,target: Target):IntArray{

    var leftIndex = 0
    var rightIndex = 0
    var currentIndex = 0
    var sortedArray = IntArray(size = left.size.plus(right.size))

    while (leftIndex < left.size && rightIndex < right.size){
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]
        if (leftElement > rightElement){
            sortedArray[currentIndex] = rightElement
            rightIndex += 1
            if (target.targetValue == rightElement){
                target.index = currentIndex
            }
        }else if (leftElement < rightElement){
            sortedArray[currentIndex] = leftElement
            leftIndex += 1
            if (target.targetValue == leftElement){
                target.index = currentIndex
            }
        }else{
            if (leftElement == target.targetValue || rightElement == target.targetValue){
                target.index = currentIndex
            }
            sortedArray[currentIndex] = rightElement
            rightIndex += 1
            currentIndex++
            sortedArray[currentIndex] = leftElement
            leftIndex += 1
        }

        currentIndex++


    }

    if (leftIndex < left.size){
        (leftIndex until left.size).forEach {
            if (left[it] == target.targetValue){
                target.index = currentIndex
            }
            sortedArray[currentIndex] = left[it]
            currentIndex++
        }
    }


    if (rightIndex < right.size){
        (rightIndex until right.size).forEach {
            if (right[it] == target.targetValue){
                target.index = currentIndex
            }
            sortedArray[currentIndex] = right[it]
            currentIndex++
        }
    }

    return sortedArray
}

fun main(){
    println(findMissing(intArrayOf(2,1,3,4,6,7)))
}


fun findMissing(array: IntArray):Int{
    var mn:String? = ""
    mn = null
    val sumOfCurrent = array.sum()
    val max = array.size + 1
    //val sumOfTotal = (max * ((max) + 1)) / 2
    var sumTotal = 0
    for (i in 0..array.size + 1){
        sumTotal  += i
    }
    return (sumTotal - sumOfCurrent).absoluteValue
    val m by lazy {

    }
}

fun mergeSortFindMissingElement(array: IntArray):Pair<Int,IntArray>{

    if (array.size == 1) return Pair(0, array)
    val middle = array.size / 2
    val left = mergeSortFindMissingElement(array.copyOfRange(0,middle))
    if (left.first != 0){
        return Pair(left.first, array)
    }
    val right = mergeSortFindMissingElement(array.copyOfRange(middle,array.size))
    if (right.first != 0){
        return Pair(right.first, array)
    }
    val result = mergeSimple(left.second,right.second)
    if (result.first != 0){
        //found missing
        return Pair(result.first, intArrayOf())
    }
    return Pair(result.first,result.second)

}

fun mergeSimple(left: IntArray,right: IntArray):Pair<Int,IntArray>{
    val sortedArray = IntArray(left.size.plus(right.size))
    var leftIndex = 0
    var rightIndex = 0
    var currentIndex = 0
    while (leftIndex < left.size && rightIndex < right.size){
        if (left[leftIndex] > right[rightIndex]){
            sortedArray[currentIndex] = right[rightIndex]
            /*if (right[rightIndex] + 1 != left[leftIndex]){
                if (right[rightIndex] + 2 == left[leftIndex]){
                    return Pair(right[rightIndex] + 1, intArrayOf())
                }
                return Pair(right[rightIndex] + 1, intArrayOf())
            }*/
            rightIndex++
        }else if(left[leftIndex] < right[rightIndex]){
            sortedArray[currentIndex] = left[leftIndex]
            /*if (left[leftIndex] + 1 != right[rightIndex]){
                if (left[leftIndex] + 2 == right[rightIndex]){
                    return Pair(left[leftIndex] + 1, intArrayOf())
                }
            }*/
            leftIndex++
        }else{
            sortedArray[currentIndex] = left[leftIndex]
            leftIndex++
            currentIndex++
            sortedArray[currentIndex] = right[rightIndex]
            rightIndex++
        }
        currentIndex++
    }

    /*Add the remaining items if left or right*/

    if (rightIndex < right.size){
        (rightIndex until right.size).forEach { index ->
           /* if (index + 1 < right.size && right[index] + 1 != right[index + 1]){
                return Pair(right[index] + 1, intArrayOf())
            }*/
            sortedArray[currentIndex] = right[index]
            currentIndex++
        }
    }

    if (leftIndex < left.size){
        (leftIndex until left.size).forEach { index ->
            /*if (index + 1 < left.size && left[index] + 1 != left[index + 1]){
                return Pair(left[index] + 1, intArrayOf())
            }*/
            sortedArray[currentIndex] = left[index]
            currentIndex++
        }
    }

    for (i in sortedArray.indices){
        if (i + 1 < sortedArray.size && sortedArray[i] + 1 != sortedArray[i + 1]){
            if (sortedArray[i + 1] == sortedArray[i] + 2){
                return Pair(sortedArray[i] + 1,sortedArray)
            }
        }
    }
    return Pair(0,sortedArray)
}

data class Mom(val m:String)