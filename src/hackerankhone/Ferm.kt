package hackerankhone


fun main(){

    println(solution(listOf(1,2),listOf(-2,-1),listOf(-1,2),listOf(0,2)))
    ms(arrayOf(1,3,4))
}

fun solution(a:List<Long>, b:List<Long>, c:List<Long>, d:List<Long>) : Long {
    // Type your solution here
    var numberOfZeroSums = 0
    for (i in a.indices){
        for (j in b.indices){
            for (k in c.indices){
                for (l in d.indices){
                    val sum = a[i] + b[j] + c[k] + d[l]
                    if (sum == 0L) numberOfZeroSums++
                }
            }
        }
    }
    return numberOfZeroSums.toLong()
}

fun ms(array:Array<Int>){

}