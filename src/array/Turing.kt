package array


fun main(){
    val ops = arrayOf("5","2","C","D","+")
    println( calpoints(ops))
}


fun calpoints(ops: Array<String>): Int {
    val result = Int.MAX_VALUE
    val regex = Regex("[0-9]")
    val resultList = mutableListOf<Int>()

    var currentNumberIndex = -1

    ops.forEachIndexed { index, op ->
        when  {
            regex.matches(op) -> {
                resultList.add(op.toInt())
                currentNumberIndex++
            }
            op == "C" -> {
                resultList.removeAt(currentNumberIndex)
                currentNumberIndex--
            }
            op == "D" ->{
                val m = resultList[currentNumberIndex]
                resultList.add(m.toInt() * 2)
                currentNumberIndex++
            }
            op == "+"-> {
                val m = resultList[currentNumberIndex] + resultList[currentNumberIndex - 1]
                resultList.add(m)
                currentNumberIndex++
            }
        }
    }




    return resultList.sum()
}