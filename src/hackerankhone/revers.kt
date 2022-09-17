package hackerankhone

fun main(){
    println(solutionR(-223372036854775809L))
}

fun solutionR(x:Long) : Long {
    // Type your solution here
    val regex = Regex("[0-9]")
    val sign:String = if (x < 0) x.toString()[0].toString() else ""

    val value = x.toString().reversed().filter { regex.matches(it.toString()) }
    val result =  (sign + value).toLong()
    return  if (result > Long.MAX_VALUE || result < Long.MIN_VALUE) 0L else result

}