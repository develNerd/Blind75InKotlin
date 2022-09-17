package hackerankhone

fun main(){
    println(minimizeBias(arrayOf(10,2,5,6,10,7,6,7,7,9,7,7)))

}

fun minimizeBias(ratings: Array<Int>): Int {
    // Write your code here
    var minimumBias = Int.MAX_VALUE
    val minimumBiasPair = mutableMapOf<Int,Int>()

    val ratingsSorted = ratings.sortedArray()
    for (i in ratingsSorted.size - 1 downTo 0 step 2){
        if (i == 0) break
        val difference = ratingsSorted[i] - ratingsSorted[i - 1]
        if (minimumBiasPair.get(difference) == null) {
            minimumBiasPair[difference] = difference
        }
        else if (difference == 0){
            minimumBiasPair[difference] = minimumBiasPair[difference]!!
        }
        else{
            minimumBiasPair[difference] = minimumBiasPair[difference]!! + minimumBiasPair[difference]!!
        }

    }


    return minimumBiasPair.values.sum()

}