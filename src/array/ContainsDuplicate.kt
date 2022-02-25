package array


/**
 *
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 *
 *
 *
 *
 * */


/**
 *
 *
 * */

fun main(){
    val nums = intArrayOf(3,3)
    println(containsDuplicate(nums))
}

fun containsDuplicate(nums: IntArray): Boolean {
    /**
     * [1,2,3,1]
     * */
    val numsMap = mutableMapOf<Int,Int>()
    for(i in nums.indices){
        if (!numsMap.containsKey(nums[i])){
            numsMap[nums[i]] = i // (i1 - {1})  (i2 - {1,2}) (i3 - {1,2,3})
        }else{
            return true
        }
    }

    return false
}


