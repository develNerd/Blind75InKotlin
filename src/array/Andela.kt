package array

fun main(){
    println(getMax3rdValue(intArrayOf(1,2,7,3,1,4,6,6,7,5,6,2,6,1)))
}

fun getMax3rdValue(array:IntArray):String{


    var maxValue = Int.MIN_VALUE

    for(i in 0..2){
        if (array[i] > maxValue){
            maxValue = array[i]
        }
    }

    val mapOfMax = mutableMapOf<Int,Int>()

    for (i in array.indices){
        if (array[i] == maxValue){
            if (mapOfMax[maxValue] != null){
                mapOfMax[maxValue] = mapOfMax[maxValue]!! + 1
            }else{
                mapOfMax[maxValue] = 1
            }
        }
    }


    return "{$maxValue:${mapOfMax[maxValue]}}"
}