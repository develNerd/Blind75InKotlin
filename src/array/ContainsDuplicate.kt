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


/**
 *
 * The solution for this is quite simple,
 * we save each integer in a mutablemap as we iterate
 * through the array if it does not exist already in
 * the array.
 *
 * */

fun containsDuplicate(nums: IntArray): Boolean {
    /**
     * Declare a mutable map to hold the key value pair
     *
     * */
    val numsMap = mutableMapOf<Int,Int>()
    for(i in nums.indices){
        /**
         * Check if [numsMap[i]] is in the mutable map keys
         * return true if the number is contained in the map keys
         * and continue otherwise
        * */
        if (!numsMap.containsKey(nums[i])){
            /**
             * Set the number as the key and the value as the index
             * */
            numsMap[nums[i]] = i // (i1 - {1})  (i2 - {1,2}) (i3 - {1,2,3})

        }else{
            return true
        }
    }

    /**
     * Return false if there is no recurring numbers in the array.
     * */
    return false
}


