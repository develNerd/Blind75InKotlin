package hackerankhone


fun main(){
    fizzBuzz(15)
}

fun fizzBuzz(n: Int): Unit {
    // Write your code here
    for(i in 1..n){
        when{
            i  % 3 == 0 && i % 5 == 0 -> {
                println("FizzBuzz")
            }
            i % 3 == 0 && i % 5 != 0 -> {
                println("Fizz")
            }
            i % 3 != 0 && i % 5 == 0 -> {
                println("Buzz")
            }
            else -> {
                println(i)
            }
        }
    }

}