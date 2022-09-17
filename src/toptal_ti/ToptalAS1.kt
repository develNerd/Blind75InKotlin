package toptal_ti

fun main(){

}

fun mergeSort(array: IntArray):IntArray{

    if (array.size  < 2) return array

    val left = mergeSort(array.copyOfRange(0,array.size/2))
    val right = mergeSort(array.copyOfRange(array.size/2,array.size))

   return merge(left, right)
}

fun merge(left:IntArray,right:IntArray):IntArray{
    var leftIndex = 0
    var rightIndex = 0
    var currentIndex = 0
    val result = IntArray(left.size.plus(right.size))
    while (leftIndex < left.size && rightIndex < right.size){
        if (left[leftIndex] < right[rightIndex]){
            result[currentIndex] = left[leftIndex]
            leftIndex++
        }else if (right[rightIndex] < left[leftIndex]){
            result[currentIndex] = right[rightIndex]
            rightIndex++
        }else{
            result[currentIndex] = left[leftIndex]
            leftIndex++
            result[currentIndex] = right[rightIndex]
            rightIndex++
        }
        currentIndex++
    }

    if (leftIndex < left.size){
        (leftIndex until left.size).forEach { index ->
            result[currentIndex]  = left[index]
            currentIndex++
        }
    }

   /* while (leftIndex < left.size){
        result[currentIndex] = left[leftIndex]
        currentIndex++
        leftIndex++
    }*/

    if (leftIndex < left.size){
        (leftIndex until left.size).forEach { index ->
            result[currentIndex]  = left[index]
            currentIndex++
        }
    }

    return result
}