package hackerankhone

fun main(){
   println(solution(10))
}

fun solution(n:Long) : Long {
    // Type your solution here
    val listOfPrime = mutableListOf<Long>()
    for (i in 2..n){
        if (isPrime(i.toInt())){
            listOfPrime.add(i)
        }else{
            continue
        }
    }
    return listOfPrime.count().toLong()
}


fun isPrime(num:Int):Boolean {

    var primeFlag = false
    for (i in 2..num / 2) {
        // condition for nonprime number
        if (num % i == 0) {
            primeFlag = true
            break
        }
    }

    return !primeFlag

}
