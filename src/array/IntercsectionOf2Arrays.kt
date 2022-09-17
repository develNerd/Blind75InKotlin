package array

fun main(){
    val num1 = intArrayOf(4,9,5)
    val num2 = intArrayOf(9,4,9,8,4)

    println(solution(num1,num2).contentToString())
}

class Empty

fun solution(array1:IntArray,array2:IntArray):IntArray{
    val m = array1 + array2

    val end =  (array1.size - 1) .plus(array2.size)
    val result = mutableListOf<Int>()
    val stopFirstIndex = array1.size - 1
    var secondBeginIndex = 0
    val checkList = mutableMapOf<Int,Int>()

    for (i in 0..end){
        if (i <= stopFirstIndex){
            checkList[i] = array1[i]
        }else{
           if (checkList.values.contains(array2[secondBeginIndex])) {
               result.add(array2[secondBeginIndex])
               checkList.remove(checkList.values.indexOf(array2[secondBeginIndex]))
           }
            secondBeginIndex++
        }
    }


    return result.toIntArray()

}