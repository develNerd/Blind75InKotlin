package array

import hackerankhone.solutionR
import kotlin.math.absoluteValue


fun main(){
    //println(solution3(mutableListOf(2,4,7,5,3,5,8,5,1,7),4,10))
    val m = "WhereIsJohn"
    val regex = Regex("[A-Z]")
    var finalString = ""
    m.forEachIndexed { index, char ->
        if(regex.matches(char.toString()) && index != 0 && index != m.lastIndex){
            finalString = "$finalString "
            finalString += char.toString()
        } else{
            finalString += char.toString()
        }
    }
    println(finalString.lowercase())
}

fun solution1(a:MutableList<Int>):MutableList<Int>{

    val b = a
    val result = mutableListOf<Int>()
    for (i in a.indices){
        fun first() = try { a[i - 1]
        } catch (e:Exception){
            0
        }

        fun second() = try { a[i]
        } catch (e:Exception){
            0
        }

        fun third() = try { a[i + 1]
        } catch (e:Exception){
            0
        }

        val sum = first() + second() + third()
        result.add(sum)
    }

    return result

}

fun solution2(a:MutableList<Int>,b:MutableList<Int>,k:Int):Int{
    val bR = b.asReversed()
    var numberOfTiny = 0
    for (i in a.indices){
        val concat = a[i].toString() + bR[i].toString()
        val value = concat.toInt()
        if (value < k){
            numberOfTiny++
        }
    }

    return numberOfTiny
}

fun solution3(a:MutableList<Int>,m:Int,K:Int):Int{
    val end = m
    var numberOFC = 0
    for (i in 0 until a.size - 1){
        if (i + end > a.size) break
        val subArray = a.toIntArray().copyOfRange(i,i + end)

        if (isEqualToK(subArray,K)){
            numberOFC++
        }
    }

    return numberOFC
}

fun isEqualToK(nums: IntArray, target: Int): Boolean {
    val sumMap = mutableMapOf<Int,Int>()

    val list = mutableListOf<String>()

    for (i in nums.indices){
        sumMap[nums[i]] = i
    }

    for (i in nums.indices){
        val compl = target - nums[i]
        if (sumMap[compl] != null && sumMap[compl] != i){
            return true
        }
    }

    return false
}

fun solution(a: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val mut = mutableMapOf<Double,MutableList<Int>>()
    for (i in a.indices){
        val mean = a[i].average()
        if (mut[mean] == null){
            mut[mean] = mutableListOf(i)
        }else{
            mut[mean] = mut[mean]!!.apply { add(i) }
        }
    }
    return mut.values.toMutableList()
}
