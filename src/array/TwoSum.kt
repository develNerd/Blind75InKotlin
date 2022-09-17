package array


// intarray 3,7,11,15,2
fun twoSum(nums: IntArray, target: Int): IntArray {
    val sumMap = mutableMapOf<Int,Int>()

    val list = mutableListOf<String>()
    list.size

    for (i in nums.indices){
        sumMap[nums[i]] = i
    }

    for (i in nums.indices ){
        val compl = target - nums[i]
        if (sumMap[compl] != null ) {
            return intArrayOf(i, sumMap[compl]!!)
        }
    }

    return intArrayOf(0,0)
}